package com.eds.service;

import com.eds.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EmployeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public List<Employee> findByFirstName(String name);
}
