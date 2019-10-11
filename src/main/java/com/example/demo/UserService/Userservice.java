package com.example.demo.UserService;

import com.example.demo.entity.TUser;
import com.example.demo.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName: demo1011
 * @Package: com.example.demo.UserService
 * @ClassName: Userservice
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/10/11 14:56
 * @Version: 1.0
 */
public interface Userservice {


    public TUser selectOne(TUser tUser);





}
