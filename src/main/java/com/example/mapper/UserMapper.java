package com.example.mapper;
import java.util.HashMap;
import java.util.List;

import com.example.vo.ChannelVO;
import com.example.vo.Criteria;
import com.example.vo.CustomerVO;
import com.example.vo.adVO;
import com.example.vo.ggimVO;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository
@Mapper
public interface UserMapper {

    List<ChannelVO> getChannelList();
    ChannelVO getAll(ChannelVO ch);
    
    List<ChannelVO> listCriteria(Criteria cri);
    int listCountCriteria(ChannelVO ch);

    List<ChannelVO> filterPage(ChannelVO ch);
    int filterPageCount(ChannelVO ch);

    List<adVO> detailPage(String url,adVO av);
    int detailCount(adVO av);

    List<ChannelVO> detailChannel(String url);

    int idCheck(CustomerVO cus);
    int regnumCheck(CustomerVO cus);
    int createCustomer(CustomerVO cus);

    int isRightCustomer(CustomerVO cus);

    int isGgim(ggimVO gvo);
    int insertGgim(ggimVO gvo);
    int deleteGgim(ggimVO gvo);

    int listGgim(ggimVO gvo);
    List<ChannelVO> showGgim(String id, ChannelVO cvo);
    

    List<ChannelVO> firstStage(HashMap<String,String[]> hm,ChannelVO cvo);
     
}

