package com.cn.bean;

public class Student {
	/**
	 * id
	 */
	private int id;
	/**
	 * ÐÕÃû
	 */
	private String studentName;
  
	/**
	 * °®ºÃ
	 */
	private String hobby;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName
				+ ", hobby=" + hobby + "]";
	}

	public Student(int id, String studentName, String hobby) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.hobby = hobby;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
