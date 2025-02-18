package com.setter.examples;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;

public class EmployeeClient {
	public static void main(String args[]) throws Exception{
		//inclusion of XML file.
		Resource res = new ClassPathResource("config.xml");
		@SuppressWarnings("deprecation")
		BeanFactory factory = new XmlBeanFactory(res);
		//inject the values via xml file.
		Employee emp = (Employee)factory.getBean("empbean");
		emp.displayValues();
	}
}