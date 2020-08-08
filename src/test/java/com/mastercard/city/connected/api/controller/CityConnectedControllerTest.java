/**
 * 
 */
package com.mastercard.city.connected.api.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mastercard.city.connected.api.service.CityConnectedService;
import com.mastercard.city.connected.api.service.impl.CityConnectedServiceImpl;

import junit.framework.Assert;

/**
 * @author Kirankumar K
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ CityConnectedControllerTest.class })
public class CityConnectedControllerTest {

	@InjectMocks
	CityConnectedServiceImpl city = new CityConnectedServiceImpl();

	@Test
	public void getCityConnetedTest() throws Exception {
		Whitebox.invokeMethod(city, "getCityConnected", new String("Boston"), new String("New York"));
		Assert.assertEquals("Yes", "Yes");

	}

	@Test
	public void getCityConnetedTest2() throws Exception {
		Whitebox.invokeMethod(city, "getCityConnected", new String("Boston"), new String("Philadelphia"));
		Assert.assertEquals("Yes", "Yes");

	}

	@Test
	public void getCityConnetedTest3() throws Exception {
		Whitebox.invokeMethod(city, "getCityConnected", new String("Philadelphia"), new String("Albany"));
		Assert.assertEquals("No", "No");

	}
	@Test
	public void getCityConnetedTest4() throws Exception {
		Whitebox.invokeMethod(city, "getCityConnected", new String("Philadelphia"), new String("jacksonville"));
		Assert.assertEquals("No", "Yes");

	}
}
