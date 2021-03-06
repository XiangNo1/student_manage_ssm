package com.situ.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String address;
	private Date birthday;
	private Integer banji_id;
	private Banji banji;
	private Kecheng kecheng;
	public Student(String name, Integer age, String gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	public Student(String name, Integer age, String gender, String address, Date birthday, Integer banji_id,
			Banji banji, Kecheng kecheng) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.banji_id = banji_id;
		this.banji = banji;
		this.kecheng = kecheng;
	}
	public Student(Integer id, String name, Integer age, String gender, String address, Date birthday, Integer banji_id,
			Banji banji, Kecheng kecheng) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.banji_id = banji_id;
		this.banji = banji;
		this.kecheng = kecheng;
	}
	public Kecheng getKecheng() {
		return kecheng;
	}
	public void setKecheng(Kecheng kecheng) {
		this.kecheng = kecheng;
	}
	public Student(String name, Integer age, String gender, String address, Date birthday, Integer banji_id) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.banji_id = banji_id;
	}
	public Student(Integer id, String name, Integer age, String gender, String address, Date birthday,
			Integer banji_id) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.banji_id = banji_id;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer id, String name, Integer age, String gender, String address, Date birthday, Integer banji_id,
			Banji banji) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.banji_id = banji_id;
		this.banji = banji;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getBanji_id() {
		return banji_id;
	}
	public void setBanji_id(Integer banji_id) {
		this.banji_id = banji_id;
	}
	public Banji getBanji() {
		return banji;
	}
	public void setBanji(Banji banji) {
		this.banji = banji;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", birthday=" + birthday + ", banji_id=" + banji_id + ", banji=" + banji + ", kecheng=" + kecheng
				+ "]";
	}
	
	
	
}
