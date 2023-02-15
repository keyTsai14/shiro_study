package com.cmqs.shirotest;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author key
 * @description
 * @create: 2023-02-12 14:01
 */
public class ShiroMD5 {

    public static void main(String[] args) {
        // 密码明文
        String password = "z3";
        // 使用MD5加密
        Md5Hash md5Hash = new Md5Hash(password);
        System.out.println("md5加密 = "+ md5Hash);

        // 带盐的m5加密，盐就是在码明文后拼按新字符串，然后再进行加密
        Md5Hash md5Hash2 = new Md5Hash(password, "salt");
        System.out.println("带盐的md5加密 = "+ md5Hash2);

        //为了保证安全，避兔被破解,还可以多次迭代伽密，保证数据安全
        Md5Hash md5Hash3 = new Md5Hash(password, "salt",3);
        System.out.println("带盐的md5加密11 = "+ md5Hash3);

        // Md5Hash的父类进行加密
        SimpleHash simpleHash =
                new SimpleHash("MD5",password, "salt",3);

        System.out.println("simpleHash=" +simpleHash);

    }
}
