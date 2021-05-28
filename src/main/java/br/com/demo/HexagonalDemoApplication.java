package br.com.demo;

import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.boot.SpringApplication.run;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableFeignClients
@EnableAsync
public class HexagonalDemoApplication {

	private static final String STUBBY_URL = "stubby.url";
	private static final String SPRING_ACTIVEMQ_PASSWORD = "spring.activemq.password";
	private static final String SPRING_ACTIVEMQ_USER = "spring.activemq.user";
	private static final String SPRING_ACTIVEMQ_BROKER_URL = "spring.activemq.broker-url";
	private static final String SERVER_SERVLET_CONTEXT_PATH = "server.servlet.context-path";
	private static final String SERVER_PORT = "server.port";
	private static final String ALL_URLS_BEGIN = "\n\n URLs:\n----------------------------------------------------------\n";
	private static final String ALL_URLS_END = "\n\n\n----------------------------------------------------------\n";
	private static final String DOCUMENTATION_URL = "\t DOCUMENTATION : \thttp://{}:{}{}/swagger-ui.html";
	private static final String JMS_ADMIN_URL = "\t ACTV_MQ-ADMIN : \thttp://{}:{}{} -- user:{} --pass:{}";
	private static final String JMS_BROKER_URL = "\t ACTV_MQ-BROKER: \t{}";
	private static final String STUBBY_SERVICE_URL= "\t STUBBY-SERVICE: \thttp://{}";

	public static void main(String[] args) throws UnknownHostException {
		var run = runApplication(args);
		
		var environment = run.getEnvironment();
		
		var serverPort = getServerPort(environment);
		
		var serverServletContextPath = getServerServeletContextPath(environment);
		
		var hostAddress = getHostAddress();
		log.info(ALL_URLS_BEGIN);
		log.info(DOCUMENTATION_URL, 
				hostAddress, 
				serverPort,
				serverServletContextPath);
		log.info(STUBBY_SERVICE_URL, 
				getStubbyUrl(environment));
		log.info(JMS_BROKER_URL, 
				getActiveMqBrokerUrl(environment));
		log.info(JMS_ADMIN_URL, 
				hostAddress, 
				"8186",
				"admin",
				getActiveMqAdminUser(environment), 
				 getActiveMqAdminPass(environment)
				);
		log.info(ALL_URLS_END);
	}

	private static ConfigurableApplicationContext runApplication(String[] args) {
		return run(HexagonalDemoApplication.class, args);
	}

	private static String getHostAddress() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}

	private static String getServerPort(ConfigurableEnvironment environment) {
		return environment.getProperty(SERVER_PORT);
	}
	
	private static String getActiveMqBrokerUrl(ConfigurableEnvironment environment) {
		return environment.getProperty(SPRING_ACTIVEMQ_BROKER_URL);
	}
	
	private static String getActiveMqAdminUser(ConfigurableEnvironment environment) {
		return environment.getProperty(SPRING_ACTIVEMQ_USER);
	}
	
	private static String getActiveMqAdminPass(ConfigurableEnvironment environment) {
		return environment.getProperty(SPRING_ACTIVEMQ_PASSWORD);
	}
	
	private static String getStubbyUrl(ConfigurableEnvironment environment) {
		return environment.getProperty(STUBBY_URL);
	}
	
	

	private static String getServerServeletContextPath(ConfigurableEnvironment environment) {
		return ofNullable(environment.getProperty(SERVER_SERVLET_CONTEXT_PATH))
				.orElse(EMPTY);
	}

}
