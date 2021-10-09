package gt.edu.umg.desaweb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tc_product")
public class TcProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	@NotNull
	private String productDesc;

	private Byte statusId;

	private Date createdAt = new Date();

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	@JsonIgnore
	private TcSupplier tcSupplier;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
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

	public TcSupplier getTcSupplier() {
		return tcSupplier;
	}

	public void setTcSupplier(TcSupplier tcSupplier) {
		this.tcSupplier = tcSupplier;
	}

}
