package net.codejava.spring.config;

import javax.sql.DataSource;

import net.codejava.spring.dao.ClienteDAO;
import net.codejava.spring.dao.ClienteDAOImpl;
import net.codejava.spring.dao.ServicioDAO;
import net.codejava.spring.dao.ServicioDAOImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/taller_mec?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true&serverTimezone=UTC");
		dataSource.setUsername("CrisArteaga");
		dataSource.setPassword("Sistemas3*");
		
		return dataSource;
	}
	
	@Bean
	public ClienteDAO getClienteDAO() {
		return new ClienteDAOImpl(getDataSource());
	}
	@Bean
	public ServicioDAO getServicioDAO() {
		return new ServicioDAOImpl(getDataSource());
	}
}
