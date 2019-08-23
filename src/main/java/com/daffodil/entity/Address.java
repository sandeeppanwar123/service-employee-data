package com.daffodil.entity;

import com.daffodil.audit.AuditEmployee;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "address")

public class Address extends AuditEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String firstLine;
    private String pinCode;
    @JoinColumn
    @ManyToOne //(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmployeeEntity employeeEntity;

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }


    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(firstLine, address.firstLine) &&
                Objects.equals(pinCode, address.pinCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstLine, pinCode);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public Address setFirstLine(String firstLine) {
        this.firstLine = firstLine;
        return this;
    }

    public String getPinCode() {
        return pinCode;
    }

    public Address setPinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }


}
