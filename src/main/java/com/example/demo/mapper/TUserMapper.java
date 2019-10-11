package com.example.demo.mapper;

import com.example.demo.entity.TUser;
import mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserMapper extends MyMapper<TUser> {
}