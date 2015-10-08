package model;

import java.util.Date;

public class Report {

	private int repid;
	private String date;
	private String month;
	private String amount;
	private String patient;
	private String presc;
	private String pemail;
	private String demail;
	
	
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
	
	
	public int getrepid() {
		return repid;
	}
	public void setrepid(int repid) {
		this.repid = repid;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public String getmonth() {
		return month;
	}
	public void setmonth(String month) {
		this.month = month;
	}
	public String getamount() {
		return amount;
	}
	public void setamount(String amount) {
		this.amount = amount;
	}
	public String getpatient() {
		return patient;
	}
	public void setpatient(String patient) {
		this.patient = patient;
	}
	
	public String getpresc() {
		return presc;
	}
	public void setpresc(String presc) {
		this.presc = presc;
	}
	
	@Override
	public String toString() {
		return "Report [repid=" + repid + ", date=" + date
				+ ", month=" + month + ", amount=" + amount + ", patient="
				+ patient +",presc="+presc+",pemail="+pemail+",demail="+demail+"]";
	}
	
	
}
