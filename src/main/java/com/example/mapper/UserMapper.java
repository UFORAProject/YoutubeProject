package com.example.mapper;
import java.util.List;

import com.example.vo.ChannelVO;
import com.example.vo.Criteria;
import com.example.vo.CustomerVO;
import com.example.vo.UserVo;
import com.example.vo.adVO;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository
@Mapper
public interface UserMapper {
    List<UserVo> getUserList();
    UserVo getUser(UserVo user);
    int createUser(UserVo user);
    int updateUser(UserVo user);
    int deleteUser(UserVo user);
    UserVo login(UserVo user);

    List<ChannelVO> getChannelList();
    ChannelVO getAll(ChannelVO ch);
    
    List<ChannelVO> listCriteria(Criteria cri);
    int listCountCriteria(ChannelVO ch);

    List<ChannelVO> filterPage(ChannelVO ch);
    int filterPageCount(ChannelVO ch);

    List<adVO> detailPage(String url,adVO av);
    int detailCount(adVO av);

    String detailChannel(String url);

    int createCustomer(CustomerVO cus);
}

