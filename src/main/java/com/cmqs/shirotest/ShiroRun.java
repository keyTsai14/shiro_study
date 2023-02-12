package com.cmqs.shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author key
 * @description
 * @create: 2023-02-09 16:06
 */
public class ShiroRun {

    public static void main(String[] args) {
        // 1 切始化获限SecurityManage
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 2 获取Subject对象
        Subject subject = SecurityUtils.getSubject();

        // 3 创建token对象， web应用用户名和密码从页面传递
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "z3");

        // 4 完成登录
        try {
            subject.login(token);
            System.out.println("login success");

            // 5 判断角色
            boolean hasRole = subject.hasRole("role1");
            System.out.println("是否拥有此角色="+hasRole);

            // 6 判断权限
            boolean permitted = subject.isPermitted("user:insert");
            System.out.println("是否拥有此权限="+permitted);
            //也可以用checkPermission方法，但没有返回值，没权限抛AuthenticationException
            subject.checkPermission("user:select");

        } catch (UnknownAccountException e) {
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }catch (Exception e) {
            System.out.println("login fail~~");
        }

    }

}
