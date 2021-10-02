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

    List<adVO> detailPage(adVO avo);
    int detailPageCount(adVO avo);

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

    /*회원 정보 수정 기능들 */
    List<CustomerVO> showCustomer(String id,CustomerVO cus);
    int modifyCustomer(CustomerVO cus);
    /*회원 정보 수정 기능들 */
    
    List<adVO> DetailADvideo(String url, adVO avo);
    String wordCloud(String url);

    List<ChannelVO> firstStage(HashMap<String,String[]> hm,ChannelVO cvo);

    int[] secondStage(HashMap<String,String[]> hm, int[] arr);
     
}

