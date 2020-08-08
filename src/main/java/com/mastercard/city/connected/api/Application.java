/**
 * 
 */
package com.mastercard.city.connected.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Kirankumar K
 *
 */

@SpringBootApplication
@ComponentScan({"com.mastercard.city.connected.api"})
@EnableAutoConfiguration
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
