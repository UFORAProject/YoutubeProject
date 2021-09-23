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

    public List<adVO> detailPage(String url,adVO av){
        return mapper.detailPage(url,av);
    }

    public int detailCount(adVO av){
        return mapper.detailCount(av);
    }

    public String detailChannel(String url){
        return mapper.detailChannel(url);
    }

    public int createCustomer(CustomerVO cus){
        return mapper.createCustomer(cus);
    }

    public int isRightCustomer(CustomerVO cus){
        return mapper.isRightCustomer(cus);
    }

    public List<ggimVO> isGgim(ggimVO gvo){
        return mapper.isGgim(gvo);
    }

    public List<ChannelVO> firstStage(HashMap<String,String[]> hm, ChannelVO cvo){
        return mapper.firstStage(hm, cvo);
    }

}
