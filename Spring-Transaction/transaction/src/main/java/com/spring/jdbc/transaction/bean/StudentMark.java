/**
 * 
 */
package com.spring.jdbc.transaction.bean;

import org.springframework.stereotype.Component;

/**
 * @author Siddhant sahu
 *
 */
@Component
public class StudentMark {
	private Integer age;
	private String name;
	private Integer id;
	private Integer marks;
	private Integer year;
	private Integer sid;

	public StudentMark() {
		super();
	}

	public StudentMark(Integer age, String name, Integer marks, Integer year) {
		super();
		this.age = age;
		this.name = name;
		this.marks = marks;
		this.year = year;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "StudentMark [age=" + age + ", name=" + name + ", id=" + id + ", marks=" + marks + ", year=" + year
				+ ", sid=" + sid + "]";
	}
}
