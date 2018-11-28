package com.spring.marcom174.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="M_ROLE")
public class RoleModel {
	private Integer id;
	private String kode;
	private String nama;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_ROLE")
	@TableGenerator(name="M_ROLE", table="M_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="M_ROLE_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="KODE")
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	
	@Column(name="NAMA")
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
}
