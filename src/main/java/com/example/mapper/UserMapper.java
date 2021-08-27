package com.example.mapper;
import java.util.List;

import com.example.vo.ChannelVO;
import com.example.vo.UserVo;

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
}

