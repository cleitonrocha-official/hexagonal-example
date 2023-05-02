package br.com.demo.adapter.inbound.rest.util;

import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.env.Environment;


import lombok.extern.slf4j.Slf4j;

/*
 * Esse objeto é usado para isolar uma regra tecnica
 */
@Slf4j
public class AddressRestUtil {

	private static final AddressRestUtil INSTANCE = new AddressRestUtil();
	private static final String SEPARADOR_URI = "/";
	private AddressRestUtil() {
		
	}
	
	public static AddressRestUtil getInstance() {
		return INSTANCE;
	}
	
	public URI buildApplicationUriAfterCreate(Environment env, String context, HttpServletRequest request, String addressId) {
		try {
			var servletPath = request.getServletPath();

			if (!servletPath.endsWith(SEPARADOR_URI)) {
				servletPath = servletPath + SEPARADOR_URI;
			}

			var host = findLocalHostAddress();
			var port = findLocalHostPort(env);
			var applicationUri = String.format("http://%s/%s/%s/%s/%s", host, port, context.replace(SEPARADOR_URI, ""), servletPath.replace(SEPARADOR_URI, ""),addressId);
			log.info("api uri with path {}", applicationUri);
			
			return new URI(applicationUri);
		} catch (Exception e) {
			return null;
		}
	}
	
	private Integer findLocalHostPort(Environment env) {
		return env.getProperty("server.port", Integer.class, 8080);
	}

	private String findLocalHostAddress() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}
	
}
