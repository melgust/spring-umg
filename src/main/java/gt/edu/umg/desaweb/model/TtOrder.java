package gt.edu.umg.desaweb.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tt_order")
public class TtOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;

	private Byte statusId = 1;

	private Date createdAt = new Date();

	@ManyToOne
	@JoinColumn(name = "client_id")
	private TcClient tcClient;

	@Transient
	private List<TtOrderDetail> detail;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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

	public TcClient getTcClient() {
		return tcClient;
	}

	public void setTcClient(TcClient tcClient) {
		this.tcClient = tcClient;
	}

	public List<TtOrderDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<TtOrderDetail> detail) {
		this.detail = detail;
	}

}
