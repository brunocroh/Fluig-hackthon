package br.com.fluig.hackathon.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Java-based Servlet initializer configuration class.
 */
public class WebAppInitializer  implements WebApplicationInitializer  {

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(AppConfig.class);
		webApplicationContext.setServletContext(servletContext);

		servletContext.addListener(new ContextLoaderListener(webApplicationContext));
		
		javax.servlet.ServletRegistration.Dynamic springMvc = servletContext.addServlet("spring-mvc", new DispatcherServlet(webApplicationContext));
		springMvc.addMapping("/services/*");
		
		javax.servlet.ServletRegistration.Dynamic apacheCxf = servletContext.addServlet("apache-cxf", new CXFServlet());
		apacheCxf.addMapping("/ws/*");
		
		
	}
}