package com.example.service;

import com.example.mapper.UserMapper;
import com.example.vo.UserVo;
import com.example.vo.ChannelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class UserService {
    @Autowired
    public UserMapper mapper;
    public List<UserVo> getUserList() {
        return mapper.getUserList();
    }
    public UserVo getUser(UserVo user) {
        return mapper.getUser(user);
    }
    public UserVo login(UserVo user) {
        return mapper.login(user);
    }

    public List<ChannelVO> getChannelList(){
        return mapper.getChannelList();
    }

}
