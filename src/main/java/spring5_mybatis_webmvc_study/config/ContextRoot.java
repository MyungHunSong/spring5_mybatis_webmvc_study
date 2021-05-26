package spring5_mybatis_webmvc_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class,MvcConfig.class})
@ComponentScan(basePackages =  {"spring5_mybatis_webmvc_study.mapper"
											  ,"spring5_mybatis_webmvc_study.controller"
											  ,"spring5_mybatis_webmvc_study.service"
											  }) 
public class ContextRoot {}
