package com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.entity.Employee;
import com.management.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Employee_Controller {

	@Autowired
	EmployeeService services;

	@GetMapping("/")
	public String index(Model m) {
		List<Employee> list = services.getAll();
		m.addAttribute("list",list);
		return "index";
	}

	@GetMapping("/base")
	public String base() {
		return "base";
	}

	@GetMapping("/editemp/{id}")
	public String editEmp(@PathVariable("id") int id, Model m) {
		Employee e= services.getById(id);
		m.addAttribute("emp", e);
		return "EditEmployee";
	}

	@GetMapping("/save")
	public String loadsaveEmp() {
		return "SaveEmployee";
	}

	@PostMapping("/saving")
	public String saveEmp(@ModelAttribute Employee employee, HttpSession session) {
		Employee e = services.saveEmployee(employee);

		if (e != null) {
			session.setAttribute("msg", "Registered Successfully!");
		} else {
			session.setAttribute("msg", "Something went wrong...");
		}

		return "redirect:/save";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee employee, HttpSession session) {
		Employee e = services.saveEmployee(employee);

		if (e != null) {
			session.setAttribute("msg", "Updated Successfully!");
		} else {
			session.setAttribute("msg", "Something went wrong...");
		}

		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable("id") int id, HttpSession session) {
		boolean eid = services.deleteById(id);

		if (eid) {
			session.setAttribute("msg", "Deleted Successfully!");
		} else {
			session.setAttribute("msg", "Something went wrong...");
		}

		return "redirect:/";
	}
}
