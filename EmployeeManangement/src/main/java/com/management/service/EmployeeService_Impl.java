package com.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.management.entity.Employee;
import com.management.repository.Employee_Repo;

import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeService_Impl implements EmployeeService {

	@Autowired
	Employee_Repo repo;

	@Override
	public Employee saveEmployee(Employee emp) {
		return this.repo.save(emp);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public boolean deleteById(int id) {
		Employee e = repo.findById(id).get();
		if (e != null) {
			repo.delete(e);
			return true;
		}
		return false;

	}

	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		session.removeAttribute("msg");
	}
}
