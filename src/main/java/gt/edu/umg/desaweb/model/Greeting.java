package gt.edu.umg.desaweb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tc_greeting")
public class Greeting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long greetingId;

	@NotNull
	private String greetingDesc;

	private Byte statusId;

	private Date createdAt = new Date();

	public long getGreetingId() {
		return greetingId;
	}

	public void setGreetingId(long greetingId) {
		this.greetingId = greetingId;
	}

	public String getGreetingDesc() {
		return greetingDesc;
	}

	public void setGreetingDesc(String greetingDesc) {
		this.greetingDesc = greetingDesc;
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
