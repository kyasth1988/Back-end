package com.eds.controller;
import com.eds.model.Employee;
import com.eds.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/EDS/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "getAllEmployes",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Iterable<Employee> getAll() {
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "employeeById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Optional<Employee> get(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    List<Employee> get(@RequestParam String name) {
        return employeeService.getEmployeeByName(name);
    }

   /* @RequestMapping(value = "addNewEmployee",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Employee> create(@RequestBody List<Employee> employee) {
        return employeeService.saveLst(employee);
    }
*/

   @RequestMapping(value = "addNewEmployee",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(value = HttpStatus.OK)
   public Employee create(@RequestBody Employee employee)
   {
       return employeeService.save(employee);
   }

    @PutMapping("updateEmployee/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Employee update(@RequestBody Employee userDto) {
        return employeeService.updateEmployee(userDto);
    }

    /*@RequestMapping(value = "deleteEmployee/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        employeeService.deleteEmployeeId(id);
    }
*/
    @DeleteMapping("deleteEmployee/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String delete(@PathVariable Long id) {
       employeeService.deleteEmployeeId(id);
         return "Deleted Successfully";
    }
}