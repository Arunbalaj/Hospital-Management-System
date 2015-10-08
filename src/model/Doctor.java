package model;

import java.util.Date;

public class Doctor {

	private int userid;
	private String firstName;
	private String lastName;
	private String Name;
	private String Pass;
	private String Role;
	private Date dob;
	private String email;
	private String address;
	private String phone;
	private String qualification;
	private String specialization;
	
	
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
	public String getqualification() {
		return qualification;
	}
	public void setqualification(String qualification) {
		this.qualification = qualification;
	}
	public String getspecialization() {
		return specialization;
	}
	public void setspecialization(String specialization) {
		this.specialization = specialization;
	}
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
	public String getRole() {
		return Role;
	}
	public void setRole(String Role) {
		this.Role = Role;
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
		return "User [userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email +", address="+ address +", phone="+ phone +", qualification="+ qualification +", specialization="+ specialization + "]";
	}
	
	
}
