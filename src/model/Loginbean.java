package model;

public class Loginbean {
	private String Name;
		private String Pass;
		private String Role;
		private int logid;
		
		public int getlogid() {
			return logid;
		}
		public void setlogid(int logid) {
			this.logid = logid;
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
			
		@Override
		public String toString() {
			// Role;
			 return "Login [Name=" + Name + ", Pass=" + Pass
						+ ", Role=" + Role +",logid="+logid+ "]";
		}
		
		
	}


