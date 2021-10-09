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
@Table(name = "tt_order_detail")
public class TtOrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderDetailId;

	private Byte statusId = 1;

	private Date createdAt = new Date();

	@ManyToOne
	@JoinColumn(name = "order_id")
	private TtOrder ttOrder;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private TcProduct tcProduct;

	private int amount;

	private int total;

	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
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

	public TtOrder getTtOrder() {
		return ttOrder;
	}

	public void setTtOrder(TtOrder ttOrder) {
		this.ttOrder = ttOrder;
	}

	public TcProduct getTcProduct() {
		return tcProduct;
	}

	public void setTcProduct(TcProduct tcProduct) {
		this.tcProduct = tcProduct;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
