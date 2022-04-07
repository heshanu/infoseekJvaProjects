package jdbc.dto;

public class BankDTO {
private long bankid;
private String name;
@Override
public String toString() {
	return "BankDTO [bankid=" + bankid + ", name=" + name + ", code=" + code + ", status=" + status + "]";
}
private String code;
private String status;
public long getBankid() {
	return bankid;
}
public void setBankid(long bankid) {
	this.bankid = bankid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
