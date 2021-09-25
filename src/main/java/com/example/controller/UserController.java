package com.example.controller;

import com.example.service.UserService;
import com.example.vo.adVO;
import com.example.vo.ggimVO;
import com.example.vo.ChannelVO;
import com.example.vo.Criteria;
import com.example.vo.CustomerVO;
import com.example.vo.FilterMaker;
import com.example.vo.PageMaker;
import com.example.vo.RecommendVO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    ////////////////////로그인 페이지로 넘기는 기능
    @RequestMapping(value="/login_page")
    public String getLoginPage(Model model,HttpSession httpSession) throws Exception{
        httpSession.removeAttribute("id");
        System.out.println("세션 아이디 지워졌음 : "+httpSession.getAttribute("id"));
        
        return "loginPage";
    }
    ////////////////////로그인 페이지로 넘기는 기능


    ///////////////회원 가입 페이지로 넘기는 기능
    @RequestMapping(value="/signPage")
    public String getSignPage(Model model) throws Exception{
        return "SignPage";
    }
    ///////////////회원 가입 페이지로 넘기는 기능

    ///////////////아이디 중복 체크
    @ResponseBody
    @RequestMapping(value="/idCheck" , method = RequestMethod.POST)
    public int idCheck(@ModelAttribute CustomerVO cus) throws Exception{
        System.out.println("id 중복 체크 확인 : "+cus.getId());
        int result = userService.idCheck(cus);
        System.out.println("이 아이디가 몇개 있냐 ! : "+result);
        return result;
    }
    ///////////////아이디 중복 체크

    ///////////////아이디 중복 체크
    @ResponseBody
    @RequestMapping(value="/regnumCheck" , method = RequestMethod.POST)
    public int regnumCheck(@ModelAttribute CustomerVO cus) throws Exception{
        System.out.println("사업등록번호 중복 체크 확인 : "+cus.getRegnum());
        int result = userService.regnumCheck(cus);
        System.out.println("사업등록번호 몇개 있냐 ! : "+result);
        return result;
    }
    ///////////////아이디 중복 체크

    //////////////////회원가입 기능
    @RequestMapping(value="/sign", method = RequestMethod.POST)
    public String sign(@ModelAttribute CustomerVO cus, Model model){
        System.out.println("아이디 : " + cus.getId());
        System.out.println("비밀번호 : " + cus.getPw());
        System.out.println("이메일 : " + cus.getEmail());
        System.out.println("서장 이름 : " + cus.getCeo());
        System.out.println("일 하는 주소 : " + cus.getAddress());
        System.out.println("연락처 : " + cus.getPhone());
        System.out.println("사업자등록 번호 : " + cus.getRegnum());
        userService.createCustomer(cus);

        return "loginPage";
    }
    //////////////////회원가입 기능


    /////////////(개발자 모드)전체 채널 조회
    @RequestMapping(value = "/get_channel_list")
    public String getAll(Model model, HttpSession session) throws Exception{
        if(session.getAttribute("id").equals("")){
            return "alert";
        }
        List<ChannelVO> channelList = userService.getChannelList(); 
        model.addAttribute("channelList", channelList);
        return "channelList";
    }
    /////////////(개발자 모드)전체 채널 조회

    ////////////////////////전체 채널 조회
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String listPage(@ModelAttribute("cri") Criteria cri, 
                            Model model,
                            ChannelVO ch, HttpServletRequest httpServletRequest, HttpSession session){
		
        CustomerVO cus = new CustomerVO();
        if(session.getAttribute("id") == null){
            if(httpServletRequest.getParameter("id") != null && httpServletRequest.getParameter("pw") != null){
                cus.setId(httpServletRequest.getParameter("id"));
                cus.setPw(httpServletRequest.getParameter("pw"));
                System.out.println("아이디 : "+cus.getId());
                System.out.println("비밀번호 : "+cus.getPw());
                if(userService.isRightCustomer(cus) == 1){
                    System.out.println("우리 아이디 맞음!!!...");
                    session.setAttribute("id", cus.getId());
                }
                else{
                    return "alert";
                }
            }
            else{
                return "alert";
            }

        }

        System.out.println("아이디 : "+session.getAttribute("id"));
		model.addAttribute("list", userService.listCriteria(cri));  // 게시판의 글 리스트
        model.addAttribute("myggimList", userService.showGgim(session.getAttribute("id").toString(), ch));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.listCountCriteria(ch));

        System.out.println("받은 값 : "+pageMaker.getCri());
        System.out.println("총 결과 수 : " +pageMaker.getTotalCount());
		
		model.addAttribute("pageMaker", pageMaker);  // 게시판 하단의 페이징 관련, 이전페이지, 페이지 링크 , 다음 페이지
		
		return "listPage";
	}
    ////////////////////////전체 채널 조회


    //////////////필터 된 결과 보여주는 기능
    @RequestMapping(value = "/filterPage", method = RequestMethod.GET)
	public String filterPage(@ModelAttribute("cvo") ChannelVO cvo,
                            Model model, HttpSession session) throws Exception {
        if(session.getAttribute("id") == null){
            return "alert";
        }
        
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
    //////////////필터 된 결과 보여주는 기능

    //////////////////////채널 상세 보기 페이지
    @RequestMapping(value="/detailPage", method = RequestMethod.GET)
    public String detailPage(@RequestParam("url") String url,Model model, HttpSession session) throws Exception{
        if(session.getAttribute("id") == null){
            return "alert";
        }
        ggimVO gvo = new ggimVO();
        gvo.setId(session.getAttribute("id").toString());
        gvo.setCh_url(url);
        model.addAttribute("ggim", userService.isGgim(gvo));
        
        System.out.println("url 제대로 넘어오는지 체크 :  "+url);
        System.out.println("아이디 : "+session.getAttribute("id"));

        adVO av = new adVO();
        model.addAttribute("detail", userService.detailChannel(url));
        
        model.addAttribute("list", userService.detailPage(url, av));
        model.addAttribute("url", url);
        return "detailPage"; 
    }
    //////////////////////채널 상세 보기 페이지


    ///////////////////////상세 페이지에서 찜하기 하는 기능
    @RequestMapping(value = "/ggimInsert", method = RequestMethod.POST)
    public String ggimInsert(@ModelAttribute ChannelVO cvo, Model model, HttpSession session) throws Exception{
        if(session.getAttribute("id") == null){
            return "alert";
        }
        System.out.println("채널 url 제대로 받아오는지 : " +cvo.getCh_url());
        System.out.println("세션아이디 제대로 받아오는지 : " +session.getAttribute("id"));
        
        ggimVO gvo = new ggimVO();
        gvo.setId(session.getAttribute("id").toString());
        gvo.setCh_url(cvo.getCh_url());
        if(userService.isGgim(gvo) == 0){
            userService.insertGgim(gvo);
        }

        String way = "redirect:detailPage" + "?url=" + cvo.getCh_url();
        return way;
    }
    ////////////////////상세 페이지에서 찜하기 하는 기능

    ///////////////////////상세 페이지에서 찜하기 제거기능
    @RequestMapping(value = "/ggimDelete", method = RequestMethod.POST)
    public String ggimDelete(@ModelAttribute ChannelVO cvo, Model model, HttpSession session) throws Exception{
        if(session.getAttribute("id") == null){
            return "alert";
        }
        System.out.println("채널 url 제대로 받아오는지 : " +cvo.getCh_url());
        System.out.println("세션아이디 제대로 받아오는지 : " +session.getAttribute("id"));
        
        ggimVO gvo = new ggimVO();
        gvo.setId(session.getAttribute("id").toString());
        gvo.setCh_url(cvo.getCh_url());
        if(userService.isGgim(gvo) >= 1){
            userService.deleteGgim(gvo);
        }
        
        String way = "redirect:detailPage" + "?url=" + cvo.getCh_url();
        return way;
    }
    ////////////////////상세 페이지에서 찜하기 제거기능

    ///////////////////////마이 페이지에서 찜하기 제거기능
    @RequestMapping(value = "/ggimErase", method = RequestMethod.POST)
    public String ggimDeleteMyPage(@ModelAttribute ChannelVO cvo, Model model, HttpSession session) throws Exception{
        if(session.getAttribute("id") == null){
            return "alert";
        }
        System.out.println("채널 url 제대로 받아오는지 : " +cvo.getCh_url());
        System.out.println("세션아이디 제대로 받아오는지 : " +session.getAttribute("id"));
        
        ggimVO gvo = new ggimVO();
        gvo.setId(session.getAttribute("id").toString());
        gvo.setCh_url(cvo.getCh_url());
        if(userService.isGgim(gvo) >= 1){
            userService.deleteGgim(gvo);
        }
        
        return "redirect:myPage";
    }
    ////////////////////마이 페이지에서 찜하기 제거기능


    /////////////////마이페이지 기능
    @RequestMapping(value = "/myPage")
    public String myPage(HttpSession session, Model model){
        if(session.getAttribute("id") == null){
            return "alert";
        }
        String id = session.getAttribute("id").toString();
        ChannelVO cvo = new ChannelVO();
        model.addAttribute("ggimList", userService.showGgim(id, cvo));
        return "myPage";
    }
    /////////////////마이페이지 기능

    /////////////////개인정보 수정으로 넘기는 기능
    @RequestMapping(value = "/modify")
    public String gotoModify(HttpSession session, Model model){

        return "CustomerModify";
    }
    /////////////////개인정보 수정으로 넘기는 기능

    ///////////////////////추천 페이지로 넘기는 기능
    @RequestMapping(value = "/SearchPage")
    public String SearchPage(HttpSession session){
        if(session.getAttribute("id") == null){
            return "alert";
        }
        return "SearchPage";
    }
    ///////////////////////추천 페이지로 넘기는 기능

    ///////////////////추천 기능
    @RequestMapping(value = "/recommend" , method = RequestMethod.POST)
    public String Recommend(@RequestParam("keyword") String rec, Model model,HttpSession session) throws Exception {
        if(session.getAttribute("id") == null){
            return "alert";
        }
        System.out.println("받은 키워드 : " +rec);
        ChannelVO cvo = new ChannelVO();
        String[] str = rec.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            sb.append("%");
            sb.append(str[i]);
            sb.append("%");
            str[i] = sb.toString();
            sb.setLength(0);
        }
        HashMap<String,String[]> hm = new HashMap<>();
        hm.put("a", str);
        model.addAttribute("general", userService.firstStage(hm, cvo)); 

        System.out.println("기존 채널 함수 완료");
        
        Runtime r = Runtime.getRuntime();
		Process p = r.exec("python src\\main\\java\\com\\example\\controller\\sim.py " +rec);
        //python + sim.py 파일이 존재하는 곳의 경로                                       //키워드를 입력받고자 함 

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String answer = "";

		try {
			p.waitFor();
			String line = "";
			while (br.ready()) {
				line = br.readLine();
                answer = line;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        answer = answer.replaceAll("\\[", "");
        answer = answer.replaceAll("\\]", "");
        answer = answer.replaceAll("'", "");
        String[] aaa = answer.split(",");
        List<RecommendVO> rvo = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < 4; i++){
            RecommendVO temp = new RecommendVO();
            temp.setCh_url(aaa[j]);
            j += 1;
            temp.setCh_name(aaa[j]);
            j += 1;
            temp.setImg(aaa[j]);
            j += 1;
            temp.setSimilarity(Double.parseDouble(aaa[j]));
            j+= 1;
            rvo.add(temp);
        }
        model.addAttribute("list", rvo);
        
        return "RecommendPage";
    }
    ///////////////////추천 기능


    //////////////////로그아웃 기능
    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public String logout(HttpSession session ) throws Exception{
        session.removeAttribute("id");
        
        return "logoutAlert";
    }

    /////////////////로그아웃 기능
}
