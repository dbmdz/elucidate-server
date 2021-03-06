package com.digirati.elucidate.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.Log4jConfigurer;
import org.springframework.util.MethodInvoker;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@SuppressWarnings("deprecation")
@ComponentScan(basePackages = {ServicesConfig.SERVICE_PACKAGE, ServicesConfig.COMMON_SERVICE_PACKAGE, ServicesConfig.INFRASTRUCTURE_PACKAGE})
public class ServicesConfig {

    public static final String SERVICE_PACKAGE = "com.digirati.elucidate.service";
    public static final String COMMON_SERVICE_PACKAGE = "com.digirati.elucidate.common.service";
    public static final String INFRASTRUCTURE_PACKAGE = "com.digirati.elucidate.infrastructure";

    @Autowired
    private Environment environment;

    @Bean(name = "log4jInitialization")
    public MethodInvoker log4j() {
        MethodInvokingFactoryBean methodInvoker = new MethodInvokingFactoryBean();
        methodInvoker.setTargetClass(Log4jConfigurer.class);
        methodInvoker.setTargetMethod("initLogging");
        methodInvoker.setArguments(getLog4jArgs());
        return methodInvoker;
    }

    private Object[] getLog4jArgs() {
        return new Object[] {environment.getRequiredProperty("log4j.config.location"), environment.getRequiredProperty("log4j.refresh.interval")};
    }

    @Bean(name = "listenerTaskExecutor", initMethod = "initialize", destroyMethod = "shutdown")
    public TaskExecutor listenerTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
