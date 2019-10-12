package com.example.demo.UserService.impl;

import com.example.demo.UserService.Userservice;
import com.example.demo.entity.TUser;
import com.example.demo.mapper.TUserMapper;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.provider.base.BaseDeleteProvider;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

import java.util.List;

/**
 * @ProjectName: demo1011
 * @Package: com.example.demo.UserService.impl
 * @ClassName: UserServiceimpl
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/10/11 14:59
 * @Version: 1.0
 */
@Service
public class UserServiceimpl implements Userservice {

    @Autowired
    TUserMapper tUserMapper;

    @SelectProvider(type=BaseSelectProvider.class, method="dynamicSQL")
    public TUser selectOne(TUser tUser) {
        return tUserMapper.selectOne( tUser );
    }

    @SelectProvider(type=BaseSelectProvider.class, method="dynamicSQL")
    public List<TUser> selectAll() {
        return tUserMapper.selectAll();
    }

    @DeleteProvider(type=BaseDeleteProvider.class, method="dynamicSQL")
    public int deleteByPrimaryKey(Object o) {
        return tUserMapper.deleteByPrimaryKey( o );
    }

    @DeleteProvider(type=BaseDeleteProvider.class, method="dynamicSQL")
    public int delete(TUser tUser) {
        return tUserMapper.delete( tUser );
    }

    public TUser seach(TUser user) {
        return tUserMapper.seach( user );
    }

    @InsertProvider(type=BaseInsertProvider.class, method="dynamicSQL")
    public int insert(TUser user) {
        return tUserMapper.insert( user );
    }

    public int insert1(TUser user) {
/**
 * @Method insert1
 * @Author ZHY
 * @Version  1.0
 * @Description
 * @param user
 * @Return int
 * @Exception
 * @Date 2019/10/12 16:58
 * 这里是插入一条数据,是用了uuid   返回类型是int类型 0和1 条
 */
        return tUserMapper.insert1( user );
    }

}
