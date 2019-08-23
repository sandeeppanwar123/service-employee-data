package com.daffodil.service;

import com.daffodil.EmployeeException;
import com.daffodil.dto.EmployeeDTO;
import com.daffodil.entity.EmployeeEntity;
import com.daffodil.mapper.EmployeeMapper;
import com.daffodil.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity addEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
        if (isEmployeeExist(employeeDTO.getEmployeeId())) {
            throw new EmployeeException("Employee already exist with given employeeId: " + employeeDTO.getEmployeeId()
                    );
        } else
            return employeeRepository.save(EmployeeMapper.map(employeeDTO));
    }

    private boolean isEmployeeExist(Integer employeeId) {
        return employeeRepository.existsByEmployeeId(employeeId);
    }

    @Transactional
    public EmployeeEntity updateEmployee(EmployeeDTO employeeDTO) {
        return employeeRepository
                .save(EmployeeMapper.map(employeeDTO));
    }

    @Transactional
    public void deleteEmployee(Integer empId) throws EmployeeException {
        if (!isEmployeeExist(empId)) {
            throw new EmployeeException("Employee does not exist with given employeeId: " + empId);
        }
        else
        employeeRepository.deleteByEmployeeId(empId);
    }

    public EmployeeEntity getEmployee(Integer empId) throws EmployeeException {
        if (isEmployeeExist(empId))
        return employeeRepository.findByEmployeeId(empId).get();
        else
            throw new EmployeeException("Employee does not exist with given employeeId: " + empId);

    }


}
