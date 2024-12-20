package Registration;

public class Regestration {

	public String Name;
	public String email;
	public String uname;
	public String pwd;

	public Regestration(String name, String email, String uname, String pwd) {
		Name = name;
		this.email = email;
		this.uname = uname;
		this.pwd = pwd;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
