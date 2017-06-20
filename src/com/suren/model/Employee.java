package com.suren.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Surendirababu Janarthanan on 6/20/2017.
 */
public class Employee implements Serializable{

    private int empId;
    private String empName;
    private Date dob;
    private BigDecimal salary;


    public Employee(EmployeeBuilder builder) {
        this.empId = builder.empId;
        this.empName = builder.empName;
        this.dob = builder.dob;
        this.salary = builder.salary;
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", dob=" + dob +
                ", salary=" + salary +
                '}';
    }

    public static class EmployeeBuilder {

        private int empId;
        private String empName;
        private Date dob;
        private BigDecimal salary;

        public static EmployeeBuilder anEmployee()
        {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder withEmpId(int empId)
        {
            this.empId = empId;
            return this;
        }

        public EmployeeBuilder withEmpName(String empName)
        {
            this.empName = empName;
            return this;
        }

        public EmployeeBuilder withEmpDob(Date dob)
        {
            this.dob = dob;
            return this;
        }

        public EmployeeBuilder withEmpSalary(BigDecimal salary)
        {
            this.salary = salary;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }

}
