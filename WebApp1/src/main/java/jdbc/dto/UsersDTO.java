package jdbc.dto;

public class UsersDTO {
	private String name;
	private String address;
	private String gender;
	private String username;
	private String password;
	private String town;
	private String qualification;

	@Override
	public String toString() {
		return "UsersDTO [name=" + name + ", address=" + address + ", gender=" + gender + ", username=" + username
				+ ", password=" + password + ", town=" + town + ", qualification=" + qualification + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
}
