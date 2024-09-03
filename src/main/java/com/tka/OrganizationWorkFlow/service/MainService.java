package com.tka.OrganizationWorkFlow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationWorkFlow.dao.MainDao;
import com.tka.OrganizationWorkFlow.entity.Country;
import com.tka.OrganizationWorkFlow.entity.Employee;

@Service
public class MainService {
	@Autowired
	MainDao dao;

	public String addCountry(Country c) {
		String msg = dao.addCountry(c);
		if (Objects.isNull(msg)) {
			msg = "Country is not added";
		}
		return msg;
	}

	public String updateCountry(Country c, int id) {
		String str = dao.updateCountry(c, id);
		if (Objects.isNull(str)) {
			str = "country is not updated";
		}
		return str;
	}

	public String deleteCountry(int cid) {
		String str = dao.deleteCountry(cid);
		if (Objects.isNull(str)) {
			str = "country is not deleted";
		}
		return str;
	}

	public List<Country> getAllRecord() {
		List<Country> list = dao.getAllRecord();
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public Country getparticularContryById(int cid) {
		Country country = dao.getparticularContryById(cid);
		if (Objects.isNull(country)) {
			country = null;
		}
		return country;
	}

	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		if (Objects.isNull(msg)) {
			msg = "employee is not added successfully";
		}

		return msg;
	}

	public String updateEmployee(Employee employee, int id) {
		String str = dao.updateEmployee(id);
		if (Objects.isNull(str)) {
			str = "employee is not updated";
		}
		return str;
	}

	public String deleteEmployee(int id) {
		String str = dao.deleteEmployee(id);
		if (Objects.isNull(str)) {
			str = "employee is not deleted";
		}
		return str;
	}

	public List<Employee> getAllEmp() {
		List<Employee> list = dao.getAllEmp();
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public Employee getPerticularEmp(int id) {
		Employee employee = dao.getPerticularEmp(id);

		if (Objects.isNull(employee)) {
			employee = null;
		}
		return employee;
	}

	public HashMap loginCheck(Employee e) {
		Employee emp = dao.loginCheck(e);

		HashMap map = new HashMap();
		if (Objects.isNull(emp)) {
			map.put("msg", "invalid user");

		} else {
			map.put("msg", "valid user");
		}
		map.put("user", emp);

		return map;
	}

	public List<Employee> getSalary(double ssalary,double esalary){
		List<Employee> list = dao.getSalary(ssalary,esalary);
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public List<Employee> getStatus(String status){
		List<Employee> list = dao.getStatus(status);
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public String updateStatus(int id) {
		String str = dao.updateStatus(id);
		if (Objects.isNull(str)) {
			str = "status is not updated";
		}
		return str;
	}



}
