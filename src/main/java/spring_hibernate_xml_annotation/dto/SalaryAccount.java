package spring_hibernate_xml_annotation.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Entity
public class SalaryAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Value("ICICI")
	String name;
	@Value("ICIC123")
	String ifsc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	@Override
	public String toString() {
		return "SalaryAccount [id=" + id + ", name=" + name + ", ifsc=" + ifsc + "]";
	}

}
