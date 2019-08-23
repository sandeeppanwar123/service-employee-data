package com.daffodil.entity;


import com.daffodil.audit.AuditEmployee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "employee")
public class EmployeeEntity extends AuditEmployee {

    @Id
    @Column(name = "empId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer employeeId;
    private String employeeName;
    @Enumerated(EnumType.STRING)
    private EmployementType employementType;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> addresses;
    @Enumerated(EnumType.STRING)
    private Department department;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer employeeId, String employeeName, EmployementType employementType, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employementType = employementType;
        this.addresses = addresses;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public EmployeeEntity setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public EmployementType getEmployementType() {
        return employementType;
    }

    public EmployeeEntity setEmployementType(EmployementType employementType) {
        this.employementType = employementType;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public EmployeeEntity setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public EmployeeEntity setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public EmployeeEntity setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public void addEmployee(Address address) {
        if (addresses == null) {
            addresses = new HashSet<>();
        }
        address.setEmployeeEntity(this);
        addresses.add(address);
    }

    public enum EmployementType {
        FULLTIME, PARTTIME, FIXEDTIME
    }


}
