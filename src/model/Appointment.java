package model;

import java.util.Date;

public class Appointment {

	private int appid;
	private String doctor;
	private String patient;
	private String descrip;
	private String appdate;
	private String apptime;
	private String pemail;
	private String demail;
	private String status;
	
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	
	
	public String getpemail() {
		return pemail;
	}
	public void setpemail(String pemail) {
		this.pemail = pemail;
	}
	
	public String getdemail() {
		return demail;
	}
	public void setdemail(String demail) {
		this.demail = demail;
	}
	
	
	public String getdescrip() {
		return descrip;
	}
	public void setdescrip(String descrip) {
		this.descrip = descrip;
	}
	
	public int getappid() {
		return appid;
	}
	public void setappid(int appid) {
		this.appid = appid;
	}
	public String getdoctor() {
		return doctor;
	}
	public void setdoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getpatient() {
		return patient;
	}
	public void setpatient(String patient) {
		this.patient = patient;
	}
	
	public String getappdate() {
		return appdate;
	}
	public void setappdate(String appdate) {
		this.appdate = appdate;
	}
	public String getapptime() {
		return apptime;
	}
	public void setapptime(String apptime) {
		this.apptime = apptime;
	}
	
	@Override
	public String toString() {
		return "Appoint [appid=" + appid + ", doctor=" + doctor
				+ ", patient=" + patient + ", appdate=" + appdate + ", apptime="
				+ apptime +",descrip="+descrip+",pemail="+pemail+",demail="+demail+",status="+status+"]";
	}
	
	
}

