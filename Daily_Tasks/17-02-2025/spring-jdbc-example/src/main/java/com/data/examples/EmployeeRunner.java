package com.data.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeRunner {
    public static void main(String[] args) {
        // Load the Spring application context from the XML configuration
        @SuppressWarnings("resource")
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

        // Get the EmployeeDao bean from the context
        EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");

        // Insertion
        int insertStatus = dao.saveEmployee(new Employee(120, "Sai Venkata Ramana", 95000));
        System.out.println("Row Inserted Successfully: " + insertStatus);

        // Update (assuming employee ID is 120 and we are updating the salary)
        Employee updatedEmployee = new Employee(120, "Sai Venkata Ramana", 105000);
        int updateStatus = dao.updateEmployee(updatedEmployee);
        System.out.println("Row Updated Successfully: " + updateStatus);

        // Deletion (assuming employee ID is 120)
    }
}
