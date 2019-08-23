package com.daffodil.repository;


import com.daffodil.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {


    Optional<EmployeeEntity> findByEmployeeId(Integer s);

    void deleteByEmployeeId(Integer integer);


    boolean existsByEmployeeId(Integer integer);
}
