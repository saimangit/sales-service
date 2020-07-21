package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="sales_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="order key is mandatory")
	@Column(name="sales_order_key")
	private String salesOrderKey;
	@NotBlank(message="pid is mandatory")
	private String pid;
	@NotBlank(message="pname is mandatory")
	private String pname;
	private Double amount;
	@Column(name="supplier_name")
	private String supplierName;
	@Column(name="supplier_contact")
	private String supplierContact;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSalesOrderKey() {
		return salesOrderKey;
	}
	public void setSalesOrderKey(String salesOrderKey) {
		this.salesOrderKey = salesOrderKey;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}
	
		
}
