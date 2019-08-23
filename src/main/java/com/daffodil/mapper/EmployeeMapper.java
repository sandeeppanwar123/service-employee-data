package com.daffodil.mapper;

import com.daffodil.dto.EmployeeDTO;
import com.daffodil.entity.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeEntity map(EmployeeDTO employeeDTO) {
        return new EmployeeEntity()
                .setAddresses(employeeDTO.getAddress())
                .setDepartment(employeeDTO.getDepartment())
                .setEmployeeId(employeeDTO.getEmployeeId())
                .setEmployeeName(employeeDTO.getEmployeeName())
                .setEmployementType(employeeDTO.getEmployementType());

    }

    public static EmployeeDTO map(EmployeeEntity employeeEntity) {
        return new EmployeeDTO()
                .setDepartment(employeeEntity.getDepartment())
                .setEmployeeId(employeeEntity.getEmployeeId())
                .setEmployeeName(employeeEntity.getEmployeeName())
                .setAddress(employeeEntity.getAddresses())
                .setEmployementType(employeeEntity.getEmployementType())
                ;


    }


}
