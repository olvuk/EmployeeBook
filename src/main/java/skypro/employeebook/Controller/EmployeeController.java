package skypro.employeebook.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import skypro.employeebook.Service.EmployeeService;
import skypro.employeebook.Employee;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @ExceptionHandler({HttpStatusCodeException.class})
    public String handleException(HttpStatusCodeException e) {
        return e.getStatusCode() + e.getMessage();
    }
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String contractNumber, @RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(contractNumber, firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String contractNumber, @RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(contractNumber, firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String contractNumber, @RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(contractNumber, firstName, lastName);
    }

    @GetMapping("/getAll")
    public Map<String, Employee> getAll() {
        return employeeService.getAll();
    }
}

