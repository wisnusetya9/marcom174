package com.spring.marcom174.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;



@Entity
@Table(name="M_USER")
public class UserModel {

	private Integer id;
	private String username;
	private String password;
	
	//JoinTableRole
	private Integer idRole;
	private RoleModel roleModel;
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_USER")
	@TableGenerator(name="M_USER", table="M_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="M_USER_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0
			)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="ID_ROLE")
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_ROLE", nullable=true, updatable=false, insertable=false)
	public RoleModel getRoleModel() {
		return roleModel;
	}
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}
	
	
	
}
