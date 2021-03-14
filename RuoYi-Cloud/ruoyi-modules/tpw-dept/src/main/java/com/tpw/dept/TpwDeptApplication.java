package com.tpw.dept;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 系统模块
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
@MapperScan(basePackages = {"com.tpw.dept.mapper"})
public class TpwDeptApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TpwDeptApplication.class, args);
        System.out.println("tpw-dept模块启动-------");
        System.out.println("tpw-dept模块启动-------");
        System.out.println("tpw-dept模块启动-------");
        System.out.println("tpw-dept模块启动-------");
        System.out.println("tpw-dept模块启动-------");
    }
}
