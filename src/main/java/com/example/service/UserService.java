package com.example.service;

import com.example.mapper.UserMapper;
import com.example.vo.ChannelVO;
import com.example.vo.Criteria;
import com.example.vo.CustomerVO;
import com.example.vo.adVO;
import com.example.vo.ggimVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;



@Service
public class UserService {
    @Autowired
    public UserMapper mapper;

    public List<ChannelVO> getChannelList(){
        return mapper.getChannelList();
    }

    public List<ChannelVO> listCriteria(Criteria cri){
        return mapper.listCriteria(cri);
    }

    public int listCountCriteria(ChannelVO ch){
        return mapper.listCountCriteria(null);
    }

    public List<ChannelVO> filterPage(ChannelVO ch){
        return mapper.filterPage(ch);
    }

    public int filterPageCount(ChannelVO ch){
        return mapper.filterPageCount(ch);
    }

    public List<adVO> detailPage(adVO avo){
        return mapper.detailPage(avo);
    }

    public int detailPageCount(adVO avo){
        return mapper.detailPageCount(avo);
    }


    public List<ChannelVO> detailChannel(String url){
        return mapper.detailChannel(url);
    }

    public int idCheck(CustomerVO cus){
        return mapper.idCheck(cus);
    }

    public int regnumCheck(CustomerVO cus){
        return mapper.regnumCheck(cus);
    }

    public int createCustomer(CustomerVO cus){
        return mapper.createCustomer(cus);
    }

    public int isRightCustomer(CustomerVO cus){
        return mapper.isRightCustomer(cus);
    }

    public int isGgim(ggimVO gvo){
        return mapper.isGgim(gvo);
    }

    public int insertGgim(ggimVO gvo){
        return mapper.insertGgim(gvo);
    }

    public int deleteGgim(ggimVO gvo){
        return mapper.deleteGgim(gvo);
    }

    public int listGgim(ggimVO gvo){
        return mapper.listGgim(gvo);
    }

    public List<ChannelVO> showGgim(String id, ChannelVO cvo){
        return mapper.showGgim(id, cvo);
    }

    public List<adVO> DetailADvideo(String url, adVO avo){
        return mapper.DetailADvideo(url, avo);
    }

    public String wordCloud(String url){
        return mapper.wordCloud(url);
    }
    
    /* 회원정보 수정 기능들 */
    public List<CustomerVO> showCustomer(String id,CustomerVO cus){
        return mapper.showCustomer(id,cus);
    }

    public int modifyCustomer(CustomerVO cus){
        return mapper.modifyCustomer(cus);
    }
    /* 회원정보 수정 기능들 */

    public List<ChannelVO> firstStage(HashMap<String,String[]> hm, ChannelVO cvo){
        return mapper.firstStage(hm, cvo);
    }

    public ArrayList<Integer> secondStage(HashMap<String,String[]> hm, ArrayList<Integer> clust){
        return mapper.secondStage(hm,clust);
    }

}
