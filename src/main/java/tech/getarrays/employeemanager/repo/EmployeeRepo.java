package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    //query method creata automat de Java vezi EmployeeService unde am instatiat-o inainte sa o cream aici.
    void deleteEmployeeById(Long id);

//    Employee findEmployeeById(Long id);
    // Vom retura un Optional<Employee> in loc de Employee pentru ca s-ar putea sa introducem un id si sa nu existe
// employee cu
// acel id -> de modeficat si in EmployeeService metoda!
    Optional<Employee> findEmployeeById(Long id);
}
