package gt.edu.umg.desaweb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tc_role")
public class TcRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;

	@NotNull
	private String roleDesc;

	private Byte statusId;

	private String code;

	private Date createdAt = new Date();

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Byte getStatusId() {
		return statusId;
	}

	public void setStatusId(Byte statusId) {
		this.statusId = statusId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
