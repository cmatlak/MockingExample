package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTestDouble implements EmployeeRepository{
private List<Employee> employees;


    public EmployeeRepositoryTestDouble(){
        this.employees = new ArrayList<>();
    }
    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    @Override
    public Employee save(Employee e) {
        employees.add(e);
        return e;
    }
}
