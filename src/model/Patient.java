package model;

import java.util.Date;

public class Patient {

	private int userid;
	private String firstName;
	private String lastName;
	private Date dob;
	private String email;
	private String address;
	private String phone;
	private String description;
	private String sex;
	private String Name;
	private String Pass;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String Pass) {
		this.Pass = Pass;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public String getsex() {
		return sex;
	}
	public void setsex(String sex) {
		this.sex = sex;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Patient [userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email +", address="+ address +", phone="+ phone +", description="+ description +", sex="+ sex + "]";
	}
	
	
}
