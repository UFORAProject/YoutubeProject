package com.example.controller;

import com.example.service.UserService;
import com.example.vo.adVO;
import com.example.vo.ChannelVO;
import com.example.vo.Criteria;
import com.example.vo.CustomerVO;
import com.example.vo.FilterMaker;
import com.example.vo.PageMaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/login_page")
    public String getLoginPage(Model model,HttpSession httpSession) throws Exception{
        httpSession.removeAttribute("id");
        System.out.println("아이디 아직 있음?"+httpSession.getAttribute("id"));
        
        return "loginPage";
    }

    @RequestMapping(value="/signPage")
    public String getSignPage(Model model) throws Exception{
        return "SignPage";
    }

    @RequestMapping(value = "/get_channel_list")
    public String getAll(Model model) throws Exception{
        List<ChannelVO> channelList = userService.getChannelList(); 
        model.addAttribute("channelList", channelList);
        return "channelList";
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String listPage(@ModelAttribute("cri") Criteria cri, 
                            Model model,
                            ChannelVO ch, HttpServletRequest httpServletRequest, HttpSession session){
		
        CustomerVO cus = new CustomerVO();
        if(httpServletRequest.getParameter("id") != null && httpServletRequest.getParameter("pw") != null){
            cus.setId(httpServletRequest.getParameter("id"));
            cus.setPw(httpServletRequest.getParameter("pw"));
            System.out.println("아이디 : "+cus.getId());
            System.out.println("비밀번호 : "+cus.getPw());
            session.setAttribute("id", cus.getId());
        }
        else{
            return "alert";
        }

        if(userService.isRightCustomer(cus) == 1){
            System.out.println("우리 아이디 맞음!!!...");
        }
        else{
            return "alert";
        }

        System.out.println("아이디 : "+session.getAttribute("id"));
		model.addAttribute("list", userService.listCriteria(cri));  // 게시판의 글 리스트
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.listCountCriteria(ch));

        System.out.println("받은 값 : "+pageMaker.getCri());
        System.out.println("총 결과 수 : " +pageMaker.getTotalCount());
		
		model.addAttribute("pageMaker", pageMaker);  // 게시판 하단의 페이징 관련, 이전페이지, 페이지 링크 , 다음 페이지
		
		return "listPage";
	}

    @RequestMapping(value = "/filterPage", method = RequestMethod.GET)
	public String filterPage(@ModelAttribute("cvo") ChannelVO cvo,
                            Model model, HttpSession session) throws Exception {

        if (cvo.getCategory()== null && session.getAttribute("cvo")!=null) { 

            cvo.setCategory( ((ChannelVO)session.getAttribute("cvo")).getCategory() );  
            cvo.setSub( ((ChannelVO)session.getAttribute("cvo")).getSub() );  

        }
        System.out.println("아이디 : "+session.getAttribute("id"));
		System.out.println("받은 카테고리 값 : "+cvo.getCategory());
        System.out.println("받은 구독자 값 : "+ cvo.getSub());

        model.addAttribute("list", userService.filterPage(cvo));
        model.addAttribute("cvo", cvo );

        session.setAttribute("cvo", cvo);  

        FilterMaker FilterMaker = new FilterMaker();
        FilterMaker.setCvo(cvo);
        FilterMaker.setTotalCount(userService.filterPageCount(cvo));

        System.out.println("받은 값 : " + FilterMaker.getCvo());
        System.out.println("총 결과 수 : " + FilterMaker.getTotalCount());
        
		
		model.addAttribute("FilterMaker", FilterMaker);  // 게시판 하단의 페이징 관련, 이전페이지, 페이지 링크 , 다음 페이지
		
		return "filterPage";
	}

    @RequestMapping(value="/detailPage", method = RequestMethod.GET)
    public String detailPage(@RequestParam("url") String url,Model model, HttpSession session) throws Exception{
        System.out.println("url 제대로 넘어오는지 체크 :  "+url);
        System.out.println("아이디 : "+session.getAttribute("id"));
        adVO av = new adVO();
        model.addAttribute("contact", userService.detailChannel(url));
        model.addAttribute("list", userService.detailPage(url, av));
        return "detailPage";
    }

    @RequestMapping(value="/sign", method = RequestMethod.POST)
    public String sign(@ModelAttribute CustomerVO cus){
        System.out.println("아이디 : " + cus.getId());
        System.out.println("비밀번호 : " + cus.getPw());
        System.out.println("이메일 : " + cus.getEmail());
        System.out.println("느그 서장 이름 : " + cus.getCeo());
        System.out.println("느그 일 하는 주소 : " + cus.getAddress());
        System.out.println("느그 연락처 : " + cus.getPhone());
        System.out.println("느그 사업자등록 번호 : " + cus.getRegnum());

        return "";
    }

    

}
