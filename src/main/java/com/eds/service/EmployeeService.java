package com.eds.service;

import com.eds.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private  EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Iterable<Employee> getAllEmployee(){
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "salary"));
    }

    @Transactional(readOnly = true)
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployeeByName(String name){
        return employeeRepository.findByFirstName(name);
    }


    public void deleteEmployeeId(Long id){
        employeeRepository.deleteById(id);
    }

    //@Transactional(readOnly = true)
    public Employee updateEmployee(Employee emp){
        return employeeRepository.save(emp);
    }

 // @Transactional(readOnly = false)
    public Employee save(Employee emp){
        return employeeRepository.save(emp);
    }

    public List<Employee> saveLst(List<Employee> employees){
        List<Employee> result = new ArrayList<>();
        if (employees == null) {
            return result;
        }
        for (Employee entity : employees) {
            result.add(save(entity));
        }
        return result;
    }

}
