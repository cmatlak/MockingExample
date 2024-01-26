package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository{




    private List<Employee> employees;
    public EmployeeRepositoryStub(){
        this.employees = new ArrayList<>();

    }
    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    @Override
    public Employee save(Employee e) {
        return e;
    }



}
