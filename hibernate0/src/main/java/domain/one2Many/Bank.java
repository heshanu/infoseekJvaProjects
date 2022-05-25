package domain.one2Many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {
//code description status
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bankId;
	private String code;
	private String name;
	private String status;

	@OneToMany
	private List<Branch> branches = new ArrayList<Branch>();

	public List<Branch> getBranches() {
		return branches;
	}



	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}



	public String getCode() {
		return code;
	}

	

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", code=" + code + ", name=" + name + ", status=" + status + ", branches="
				+ branches + "]";
	}

}
