package spring_hibernate_xml_annotation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import spring_hibernate_xml_annotation.dto.Employee;

@Component
public class EmployeeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shree");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}

	public Employee fetchEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			System.out.println(employee);
			return employee;
		} else {
			System.out.println("Employee with the given id is not found");
			return null;
		}
	}

	public void updateEmployee(int id,Employee employee) {
		Employee dbEmployee = entityManager.find(Employee.class,id);
			entityTransaction.begin();
			entityManager.merge(dbEmployee);
			entityTransaction.commit();
	}

	public void deleteEmployee(int id) {
		Employee dbEmployee = entityManager.find(Employee.class, id);

		if (dbEmployee != null) {
			entityTransaction.begin();
			entityManager.remove(dbEmployee);
			entityTransaction.commit();
		} else {
			System.out.println("Employee with the given id is not found");
		}
	}

	public void getAllEmployees() {
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		List<Employee> list = query.getResultList();
		System.out.println(list);
	}

}
