package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bankId;
	private String code;
	private String description;
	private String status;
	@OneToOne
	@JoinColumn(name="managerId")
	private Manager manager;
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Bank() {}

	

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", code=" + code + ", description=" + description + ", status=" + status
				+ ", manager=" + manager + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	
}
