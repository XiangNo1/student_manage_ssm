package com.situ.ssm.pojo;

import java.io.Serializable;
import java.util.List;

public class Banji implements Serializable{

	private Integer id;
	private String name;
	private List<Kecheng> list;
	private List<Student> studentList;
	public Banji(Integer id, String name, List<Kecheng> list, List<Student> studentList) {
		super();
		this.id = id;
		this.name = name;
		this.list = list;
		this.studentList = studentList;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public Banji() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Banji(String name) {
		super();
		this.name = name;
	}
	public Banji(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Banji(Integer id, String name, List<Kecheng> list) {
		super();
		this.id = id;
		this.name = name;
		this.list = list;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Kecheng> getList() {
		return list;
	}
	public void setList(List<Kecheng> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Banji [id=" + id + ", name=" + name + ", list=" + list + ", studentList=" + studentList + "]";
	}
	
	
	
}
