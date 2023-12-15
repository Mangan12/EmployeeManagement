package com.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.entity.Employee;

public interface Employee_Repo extends JpaRepository<Employee, Integer> {

}
