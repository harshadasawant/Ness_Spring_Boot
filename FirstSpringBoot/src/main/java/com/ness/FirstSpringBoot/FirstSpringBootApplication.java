package com.ness.FirstSpringBoot;

import com.ness.controller.CustomerLoginController;
import com.ness.dto.CustomerLoginDTO;
import com.ness.exception.HndBankException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = "com.ness")
public class FirstSpringBootApplication implements CommandLineRunner {

	public static final Log LOGGER = LogFactory.getLog(FirstSpringBootApplication.class);
	@Autowired
	CustomerLoginController customerLoginController;

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		try{
			System.out.println("Hello");
			CustomerLoginDTO customerLogin = new CustomerLoginDTO();
			customerLogin.setLoginName("harry");
			customerLogin.setPassword("harry123");
			String ret = customerLoginController.authenticateCustomer(customerLogin);
			LOGGER.info(environment.getProperty(ret));

		}catch(HndBankException exception){
			LOGGER.error(environment.getProperty(exception.getMessage()));
		}
	}


}
