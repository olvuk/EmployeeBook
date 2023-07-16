package skypro.employeebook.Service;

import org.springframework.stereotype.Service;
import skypro.employeebook.Exception.EmployeeAlreadyAddedException;
import skypro.employeebook.Exception.EmployeeNotFoundException;
import skypro.employeebook.Employee;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    public Employee add(String contractNumber, String firstName, String lastName) {

        Employee newEmployee = new Employee(firstName, lastName);

        if (employees.containsValue(newEmployee) || employees.containsKey(contractNumber)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в базе");
        }
        employees.put(contractNumber, newEmployee);
        return newEmployee;
    }

    public Employee remove(String contractNumber, String firstName, String lastName) {
        Employee EmployeeToRemove = new Employee(firstName, lastName);
        if (employees.containsValue(EmployeeToRemove)) {
            return employees.remove(contractNumber);
        }
        else throw new EmployeeNotFoundException("Сотрудник не удален,так как не найден");
    }

    public Employee find(String contractNumber, String firstName, String lastName) {
        Employee employeeToFind = new Employee(firstName, lastName);
        if (employees.containsValue(employeeToFind)) {
            return employees.get(contractNumber);
        }
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    public Map<String, Employee> getAll() {
        return employees;
    }
}
