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
@Table(name="M_USERACCESS")
public class UserAccessModel {
	
	private Integer id;
	
	//join ke role
	private Integer idRole;
	private RoleModel roleModel;
	
	//join ke menu
	private Integer idMenu;
	private MenuModel menuModel;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_USERACCESS")
	@TableGenerator(name="M_USERACCESS", table="M_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="M_USERACCESS_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	@Column(name="ID_MENU")
	public Integer getIdMenu() {
		return idMenu;
	}
	
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_MENU", nullable=true, updatable=false, insertable=false)
	public MenuModel getMenuModel() {
		return menuModel;
	}
	
	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
	
	

}
