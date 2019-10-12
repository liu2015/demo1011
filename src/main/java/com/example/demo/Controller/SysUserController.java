package com.example.demo.Controller;

import com.example.demo.UserService.impl.SysUserServiceimpl;
import com.example.demo.UserService.impl.UserServiceimpl;
import com.example.demo.entity.SysUser;
import com.example.demo.entity.TUser;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.krb5.internal.crypto.EType;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

import java.util.List;

/**
 * @ProjectName: demo1011
 * @Package: com.example.demo.Controller
 * @ClassName: SysUserController
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/10/12 13:55
 * @Version: 1.0
 */
@Controller
public class SysUserController {

    @Autowired
    SysUserServiceimpl sysUserServiceimpl;
    @Autowired
    UserServiceimpl userServiceimpl;


    @RequestMapping("/tologin")
    @SelectProvider(type=BaseSelectProvider.class, method="dynamicSQL")
    public String selectOne(SysUser user, ModelMap map) {
        Subject subject =SecurityUtils.getSubject();
        UsernamePasswordToken userToken=new UsernamePasswordToken( user.getLoginName(),user.getPassword() );
            try {
                subject.login( userToken );
                System.out.println( "成功" );
                return "redirect:/list";
            } catch (UnknownAccountException e) {
                //用户名不存在
                map.addAttribute("msg","用户名不存在");
                return "login";
            }catch (IncorrectCredentialsException e) {
                //密码错误
                map.addAttribute("msg","密码错误");
                return "login";
            }
    }

    @RequestMapping("/login")
    public String login(){

        return "login";
    }
    @RequestMapping("/")
    public String index(){
        return "login";
    }
    @RequestMapping("/list")
    public String list(ModelMap map){
        List<TUser> all=userServiceimpl.selectAll(  );
        map.addAttribute( "all",all );
        return "list";
    }

    @RequestMapping("/edit/{userId}")
    public String selectone(@PathVariable String userId,ModelMap map){
        TUser dd=new TUser();
        dd.setUserId( userId );
        TUser selectone=userServiceimpl.selectOne( dd );
        map.addAttribute( "user",selectone );

        return "edit";
    }

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable String userId)
    {
        TUser dd=new TUser();
        dd.setUserId( userId );
        userServiceimpl.delete( dd );
        return "redirect:/list";
    }

    @RequestMapping("seachAll")
    public String seach(TUser user,ModelMap map){

        TUser users= userServiceimpl.seach( user );
        map.addAttribute( "seachAll",users );
        return "seach";
    }

    @RequestMapping("/seach")
    public String seachall(){


        return "seach";
    }

    @RequestMapping("/toAdd")
    public String add(){

        return "add";
    }
    @RequestMapping("/add")
    public String add(TUser user){
        userServiceimpl.insert1( user );

        return "redirect:/list";

    }

}
