package com.tka.OrganizationWorkFlow.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationWorkFlow.entity.Country;
import com.tka.OrganizationWorkFlow.entity.Employee;

@Repository
public class MainDao {
	@Autowired
    SessionFactory factory;
	public String addCountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
		
		session=factory.openSession();
		tx=session.beginTransaction();
		session.persist(c);
		tx.commit();
		msg="country Added Successfully...";
		}catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			
			if(session!=null) {
				session.close();
			}
			
		}
	return msg;	
	}
	
	public String updateCountry(Country c, int id) {
	Session session=null;
	Transaction tx=null;
	String msg= null;
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		Country country=session.get(Country.class, id);
		country.setCname(c.getCname());
		session.merge(country);
		tx.commit();
		msg="country is updated";
		
	}catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}finally {
		
		
		if(session!=null) {
			session.close();
		}
		
	}
return msg;	
}

	public String deleteCountry(int cid) {
		Session session= null;
		Transaction tx= null;
		String msg= null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Country country= session.get(Country.class,cid);
			session.remove(country);
			tx.commit();
			msg="country is deleted";
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
		}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				
		}
		}
		return msg;
	}

	public List<Country> getAllRecord() {
		Session session= null;
		Transaction tx= null;
		List<Country>list=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Country";
			
			Query<Country> query=session.createQuery(hqlQuery,Country.class);
			list=query.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
		}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				
		}
		}
		return list;
	}

	public Country getparticularContryById(int cid) {
		Session session= null;
		Transaction tx= null;
		Country country=null;
		
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			country=session.get(Country.class, cid);
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
		}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				
		}
		}
		return country;
	}

	public String addEmployee(Employee emp) {
		Session session= null;
		Transaction tx= null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg="employee added successfully";
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
		}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				
		}
		}
		return msg;
	}

	public String updateEmployee(int id) {
		Session session=null;
		Transaction tx=null;
		String msg= null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Employee emp=session.get(Employee.class, id);
			emp.setName(emp.getName());
			emp.setUpdateddate(emp.getUpdateddate());
			emp.setUpdatedby(emp.getUpdatedby());
			emp.setStatus(emp.getStatus());
			emp.setSalary(emp.getSalary());
			emp.setMobno(emp.getMobno());
			emp.setId(emp.getId());
			emp.setGender(emp.getGender());
			emp.setEmailid(emp.getEmailid());
			emp.setDepartment(emp.getDepartment());
			emp.setCreateddate(emp.getCreateddate());
			emp.setCreatedby(emp.getCreatedby());
			emp.setCountry(emp.getCountry());
			session.merge(emp);
			tx.commit();
			msg="employee is updated";
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			
			if(session!=null) {
				session.close();
			}
			
		}
	return msg;	
	}

	public String deleteEmployee(int id) {	
		Session session= null;
		Transaction tx= null;
		String msg= null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Employee emp= session.get(Employee.class,id);
			session.remove(emp);
			tx.commit();
			msg="employee is deleted";
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
		}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				
		}
		}
		return msg;
	}

	public List<Employee> getAllEmp() {
		Session session=null;
		Transaction tx= null;
        List<Employee>list=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Employee";
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			list=query.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
		}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				
		}
		}
		return list;
	}

	public Employee getPerticularEmp(int id) {
		Session session= null;
		Transaction tx= null;
		Employee employee=null;
		
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			employee=session.get(Employee.class, id);
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
		}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				
		}
		}
		return employee;
	}

	public Employee loginCheck(Employee e) {
		Session session= null;
		Transaction tx= null;
		Employee employee=null;
		
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Employee where emailid=:emailid and mobno=:mobno";
			
			Query<Employee> query=session.createQuery(hqlQuery);
			query.setParameter("emailid",e.getEmailid());
			query.setParameter("mobno", e.getMobno());
			employee=query.uniqueResult();
			tx.commit();
			
	}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
		}
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				
		}
		}
		return employee;
	}



	public List<Employee> getSalary(double ssalary,double esalary) {
		Session session=null;
		Transaction tx= null;
        List<Employee>list=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Employee where salary between :mystartSal and :myendSal";
			
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			query.setParameter("mystartSal",ssalary );
			query.setParameter("myendSal",esalary );
			list=query.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
		}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				
		}
		}
		return list;
	}

	public List<Employee> getStatus(String status) {
		Session session=null;
		Transaction tx= null;
        List<Employee>list=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Employee where status=:status";
			
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			query.setParameter("status", status);
			list=query.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
		}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				
		}
		}
		return list;
	}

	public String updateStatus(int id) {
		Session session=null;
		Transaction tx=null;
		String msg= null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Employee emp=session.get(Employee.class, id);
			if(Objects.isNull(emp)) {
				msg="Record is not found";
			}else {
				
				if(emp.getStatus().equalsIgnoreCase("suspend")) {
					msg="Status is not updated due to suspend";
				}else {
					String status="active".equalsIgnoreCase(emp.getStatus())?"inactive":"active";
					emp.setStatus(status);
					session.merge(emp);
					msg="Status is updated";
				}
				
			}
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			
			if(session!=null) {
				session.close();
			}
			
		}
	return msg;	
	}
		}
	
	
		