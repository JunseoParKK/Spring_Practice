package com.core.core.beanfind;

import com.core.core.AutoAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicBeanTest {

    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    void findAllBeanTest(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for(String beanDefinitionName:beanDefinitionNames){
            Object bean=ac.getBean(beanDefinitionName);
            System.out.println("name: "+beanDefinitionName+" | object: "+bean);
        }
    }

    @Test
    void findApplicationBeanTest(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for(String beanDefinitionName:beanDefinitionNames){
            BeanDefinition beanDefinition=ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean=ac.getBean(beanDefinitionName);
                System.out.println("name: "+beanDefinitionName+" | object: "+bean);
            }
        }
    }
}
