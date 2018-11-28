package com.spring.marcom174.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="M_PRODUCT", uniqueConstraints={@UniqueConstraint(columnNames={"NAME"})})
public class ProductModel {
	
	private Integer id;
	private String  code;
	private String name;
	private String description;
	
	//AuditTrail/////
	private Integer isDelete;
	private String createdBy;
	
	private Date createdDate;
	private String updatedBy;
	
	private Date updatedDate;
	//AuditTrail/////
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_PRODUCT")
	@TableGenerator(name="M_PRODUCT", table="M_SEQUENCE",
					pkColumnName="SEQUENCE_NAME", pkColumnValue="M_PRODUCT_ID",
					valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0
					)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@NotNull
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="IS_DELETE")
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	
	@Column(name="UPDATE_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
	
	
}
