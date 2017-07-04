package BeanDAOFile;

public class UserBean {
	
    private String name;
    private String pass;
    private String email;
  
    public boolean valid;
	
	

	
    public String getEmail() {
       return email;
			}

    public void setEmail(String newEmail) {
       email = newEmail;
			}
			

    public String getPass() {
       return pass;
	}

    public void setPass(String newPass) {
       pass = newPass;
	}
	
			
    public String getName() {
       return name;
			}

    public void setName(String newName) {
       name = newName;
			}

				
    public boolean isValid() {
       return valid;
	}

    public void setValid(boolean newValid) {
       valid = newValid;
	}	
}