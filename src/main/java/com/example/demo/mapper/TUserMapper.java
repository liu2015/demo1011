package com.example.demo.mapper;

import com.example.demo.entity.TUser;
import mybatis.MyMapper;

public interface TUserMapper extends MyMapper<TUser> {

    TUser seach(TUser user);
    int insert1(TUser user);
}