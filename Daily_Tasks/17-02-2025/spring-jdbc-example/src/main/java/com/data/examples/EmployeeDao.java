package com.data.examples;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
   private JdbcTemplate jdbcTemplate;

   public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
   }

   public int saveEmployee(Employee e) {
       String query = "INSERT INTO employee (emp_id, emp_name, emp_sal) VALUES (?, ?, ?)";
       return jdbcTemplate.update(query, e.getId(), e.getName(), e.getSalary());
   }

   public int updateEmployee(Employee e) {
       String query = "UPDATE employee SET emp_name = ?, emp_sal = ? WHERE emp_id = ?";
       return jdbcTemplate.update(query, e.getName(), e.getSalary(), e.getId());
   }

   public int deleteEmployee(Employee e) {
       String query = "DELETE FROM employee WHERE emp_id = ?";
       return jdbcTemplate.update(query, e.getId());
   }
}
