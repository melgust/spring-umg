package gt.edu.umg.desaweb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tc_user_role")
public class TcUserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userRoleId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private TcUser tcUser;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private TcRole tcRole;

	private Byte statusId;

	private Date createdAt = new Date();

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public TcUser getTcUser() {
		return tcUser;
	}

	public void setTcUser(TcUser tcUser) {
		this.tcUser = tcUser;
	}

	public TcRole getTcRole() {
		return tcRole;
	}

	public void setTcRole(TcRole tcRole) {
		this.tcRole = tcRole;
	}

	public Byte getStatusId() {
		return statusId;
	}

	public void setStatusId(Byte statusId) {
		this.statusId = statusId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
