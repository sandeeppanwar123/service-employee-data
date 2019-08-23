package com.daffodil.dto;

import com.daffodil.entity.Address;
import com.daffodil.entity.Department;
import com.daffodil.entity.EmployeeEntity;

import java.util.Set;

public class EmployeeDTO {
    private Integer employeeId;
    private String employeeName;
    private Set<Address> address;
    private Department department;
    private EmployeeEntity.EmployementType employmentType;

    public EmployeeEntity.EmployementType getEmployementType() {
        return employmentType;
    }

    public EmployeeDTO setEmployementType(EmployeeEntity.EmployementType employementType) {
        this.employmentType = employementType;
        return this;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public EmployeeDTO setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public EmployeeDTO setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public EmployeeDTO setAddress(Set<Address> address) {
        this.address = address;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public EmployeeDTO setDepartment(Department department) {
        this.department = department;
        return this;
    }
}
