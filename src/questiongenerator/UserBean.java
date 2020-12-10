package questiongenerator;

public class UserBean {
	 private String username;
     private String password;
     private String role;
     public static String empid;
     public boolean valid;
	
	
//     public String getFirstName() {
//        return firstName;
//	}
//
//     public void setFirstName(String newFirstName) {
//        firstName = newFirstName;
//	}

//	
//     public String getLastName() {
//        return lastName;
//			}
//
//     public void setLastName(String newLastName) {
//        lastName = newLastName;
//			}
//			

     public String getPassword() {
        return password;
	}

     public void setPassword(String newPassword) {
        password = newPassword;
	}
	
			
     public String getUsername() {
        return username;
			}

     public void setUserName(String newUsername) {
        username = newUsername;
			}

				
     public boolean isValid() {
        return valid;
	}

     public void setValid(boolean newValid) {
        valid = newValid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmpid() {
		// TODO Auto-generated method stub
	//	System.out.println("getter"+empid);
		return empid;
	}
	public void setEmpid(String empid2) {
		// TODO Auto-generated method stub
	//	System.out.println("before setter"+empid2);
		this.empid=empid2;
	//	System.out.println("after setter"+empid2);
	}

}
