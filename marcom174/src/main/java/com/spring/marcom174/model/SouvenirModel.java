package com.spring.marcom174.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="M_SOUVENIR")
public class SouvenirModel {

	private Integer id;
	private String code;
	private String name;
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_SOUVENIR")
	@TableGenerator(name="M_SOUVENIR", table="M_SEQUENCE",
					pkColumnName="SEQUENCE_NAME", pkColumnValue="M_SOUVENIR_ID",
					valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
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
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
