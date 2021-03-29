package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired // sa putem aduce dependinta
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById (Long id){
//        return employeeRepo.findEmployeeById(id);
        // in EmployeeRepo am schimbat return ul metodei in Optional si drept urmare daca nu gasim un employee cu id
        // ul respectiv se duce pe orElseThrow()
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " " +
                "was not found"));
        // va trebui sa cream exceptia UserNotFoundException()

    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
        // ne putem crea propria metoda EmployeeRepo daca nu exista
//        employeeRepo.deleteEmployeeById(id);
    }


}
