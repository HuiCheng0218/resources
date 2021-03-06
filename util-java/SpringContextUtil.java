package com.chngenesis.nebula.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;


public class SpringContextUtil  implements ApplicationContextAware {// Spring应用上下文环境    
    private static ApplicationContext applicationContext;    
    /**  
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境  
     *   
     * @param applicationContext  
     */    
    public void setApplicationContext(ApplicationContext applicationContext) {    
        SpringContextUtil.applicationContext = applicationContext;    
    }    
    /**  
     * @return ApplicationContext  
     */    
    public static ApplicationContext getApplicationContext() {    
        if(applicationContext == null) {  
            applicationContext = ContextLoader.getCurrentWebApplicationContext();  
        }  
        if(applicationContext == null) {  
            applicationContext = new ClassPathXmlApplicationContext("spring.cfg.xml");  
        }  
        return applicationContext;    
    }     
    /**  
     * 获取对象  
     *   
     * @param name  
     * @return Object 
     * @throws BeansException  
     */    
    public static Object getBean(String name) throws BeansException { 
    	if(null == applicationContext) {
    		getApplicationContext();
    	}
        return applicationContext.getBean(name);    
    }    
    
}
