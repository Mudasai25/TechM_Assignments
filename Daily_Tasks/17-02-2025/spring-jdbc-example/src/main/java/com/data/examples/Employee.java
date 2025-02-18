package com.data.examples;

public class Employee {
    private int emp_id;
    private String emp_name;
    private int emp_sal;

    // Default constructor
    public Employee() {}

    // Parameterized constructor
    public Employee(int emp_id, String emp_name,int emp_sal) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sal = emp_sal;
    }

    // Getter methods
    public int getId() {
        return emp_id;
    }

    public String getName() {
        return emp_name;
    }

    public int getSalary() {
        return emp_sal;
    }

    // Setter methods
    public void setId(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setName(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setSalary(int emp_sal) {
        this.emp_sal = emp_sal;
    }
}
