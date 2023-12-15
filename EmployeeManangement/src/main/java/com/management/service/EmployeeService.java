package com.management.service;

import java.util.List;

import com.management.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp);

	List<Employee> getAll();

	public Employee getById(int id);

	public boolean deleteById(int id);

}
