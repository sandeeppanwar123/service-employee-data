package com.daffodil.resources;

import com.daffodil.EmployeeException;
import com.daffodil.dto.EmployeeDTO;
import com.daffodil.mapper.EmployeeMapper;
import com.daffodil.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeResource.class);
    private EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/create")
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDTO) throws EmployeeException {
        logger.info("creating employee with employeeId :" + employeeDTO.getEmployeeId());
        return EmployeeMapper.map(employeeService.addEmployee(employeeDTO));
    }

    @PostMapping(value = "/update")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO) {
        logger.info("updating employee with employeeId :" + employeeDTO.getEmployeeId());
        return EmployeeMapper.map(employeeService.updateEmployee(employeeDTO));
    }

    @GetMapping(value = "/get/{empId}")
    public EmployeeDTO getEmployee(@PathVariable Integer empId) throws EmployeeException {
        logger.info("getting employee details for employeeId :" + empId);
        return EmployeeMapper.map(employeeService.getEmployee(empId));
    }

    @GetMapping(value = "/delete/{empId}")
    public String deleteEmployee(@PathVariable Integer empId) throws EmployeeException {
        logger.info("deleting employee details for employeeId :" + empId);
        employeeService.deleteEmployee(empId);
        return "{Employee deleted for employeeId: "+ empId+"}";
    }
}




