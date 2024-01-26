package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class EmployeesTest {

    @Test
    @DisplayName("Successful payment of employee")
    void successfulPaymentOfEmployee() {
        EmployeeRepositoryStub EmployeeRepositoryStub = mock(EmployeeRepositoryStub.class);

        BankServiceStub BankServiceStub = mock(BankServiceStub.class);

        Employees employees  = new Employees(EmployeeRepositoryStub,BankServiceStub);

        List<Employee> testEmployee = new ArrayList<>();
            testEmployee.add(new Employee("1",3000));
            testEmployee.add(new Employee("2",30001));




        when(EmployeeRepositoryStub.findAll()).thenReturn(testEmployee);
        doNothing().when(BankServiceStub).pay(anyString(), anyDouble());

            int payments = employees.payEmployees();

            assertEquals(testEmployee.size(),payments);

            assertTrue(testEmployee.get(0).isPaid());
            assertTrue(testEmployee.get(1).isPaid());




    }
    @Test
    @DisplayName("Failed payment of employee")
    void failedPaymentOfEmployee() {

        EmployeeRepositoryStub employeeRepositoryStub = mock(EmployeeRepositoryStub.class);


        BankServiceStub bankServiceStub = mock(BankServiceStub.class);
        doThrow(new RuntimeException("Payment failed")).when(bankServiceStub).pay(anyString(), anyDouble());


        Employees employees = new Employees(employeeRepositoryStub, bankServiceStub);

        List<Employee> testEmployee = new ArrayList<>();
        testEmployee.add(new Employee("1", 3000));
        testEmployee.add(new Employee("2", 30001));

        when(employeeRepositoryStub.findAll()).thenReturn(testEmployee);


        int payments = employees.payEmployees();


        assertEquals(0, payments);


        assertFalse(testEmployee.get(0).isPaid());
        assertFalse(testEmployee.get(1).isPaid());
    }

}