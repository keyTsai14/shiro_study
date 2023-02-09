package com.cmqs.shirotest;

import org.apache.shiro.SecurityUtils;
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
        } catch (Exception e) {
            System.out.println("login fail~~");
        }

    }

}
