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

    public List<ChannelVO> firstStage(HashMap<String,String[]> hm, ChannelVO cvo){
        return mapper.firstStage(hm, cvo);
    }

}
