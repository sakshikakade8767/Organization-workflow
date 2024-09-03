package com.tka.OrganizationWorkFlow.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationWorkFlow.entity.Country;
import com.tka.OrganizationWorkFlow.entity.Employee;
import com.tka.OrganizationWorkFlow.service.MainService;
@CrossOrigin
@RestController
@RequestMapping("api")

public class MainController {
	@Autowired
	MainService service;
	
	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {
     String msg= service.addCountry(c);
     return msg;
	}
	
@PutMapping("updatecountry/{id}")
public String updateCountry(@RequestBody Country c,@PathVariable int id) {
	String str=service.updateCountry(c,id);	
	 return str;
	 }

@DeleteMapping("deletecountry/{id}")
public String deleteCountry(@PathVariable int cid) {
	String str=service.deleteCountry(cid);	
	 return str;
}
@GetMapping("getallcountry")
public List<Country>getAllRecord(){
	List<Country>list=service.getAllRecord();
	return list;
}

@GetMapping("getcountrybyid/{cid}")
public Country getparticularContryById(@PathVariable int cid) {
	Country country=service.getparticularContryById(cid);
	return country;
}

@PostMapping("addemp")
public String addEmployee(@RequestBody Employee emp) {
String str=service.addEmployee(emp);
return str;
}


@PutMapping("updateemp/{id}")
public String updateEmployee(@RequestBody Employee emp,@PathVariable int id) {
String str=service.updateEmployee(emp, id);		
 return str;
 }

@DeleteMapping("deleteemp/{id}")
public String deleteEmployee(@PathVariable int id) {
	String str=service.deleteEmployee(id);	
	 return str;
}

@GetMapping("getallemp")
public List<Employee>getAllEmp(){
	List<Employee>list=service.getAllEmp();
	return list;
}

@GetMapping("getperticularemp/{id}")
public Employee getPerticularEmp(@PathVariable int id) {
	Employee employee=service.getPerticularEmp(id);
	return employee;
}
@PostMapping("login")
public HashMap loginCheck(@RequestBody Employee e) {
	HashMap map=service.loginCheck(e);
	return map;
}
@GetMapping("getsalary/{ssalary},{esalary}")
public List<Employee> getSalary(@PathVariable double ssalary,@PathVariable double esalary){
	List<Employee> list=service.getSalary( ssalary, esalary);
	return list;
}
@GetMapping("getstatus/{status}")
public List<Employee>getStatus(@PathVariable String status){
	List<Employee> list=service.getStatus(status);
	return list;
}

@GetMapping("updatestatus/{id}")
public String updateStatus(@PathVariable int id) {
	String str= service.updateStatus(id);
	return str;
}
}
