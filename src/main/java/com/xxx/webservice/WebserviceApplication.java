package com.xxx.webservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.MultipartConfigElement;


@MapperScan("com.xxx.webservice.dao")
@ComponentScan(value="com.xxx")
@SpringBootApplication
public class WebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebserviceApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("128MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("256MB");
        //Sets the directory location wherefiles will be stored.
//        factory.setLocation("E:\\素材\\测试图片");
        return factory.createMultipartConfig();
    }
}
