package spring_hibernate_xml_annotation.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_hibernate_xml_annotation.dao.EmployeeDao;
import spring_hibernate_xml_annotation.dto.Employee;

public class MainController {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("employee.xml");
		EmployeeDao dao = applicationContext.getBean("employeeDao", EmployeeDao.class);
		Employee employee = applicationContext.getBean("employee", Employee.class);
//		dao.saveEmployee(employee);
//		dao.fetchEmployee(2);
		dao.updateEmployee(1,employee);
//		dao.deleteEmployee(3);
//		dao.getAllStudents();
	}
}
