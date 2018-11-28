package com.spring.marcom174.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="T_EVENT")
public class EventModel {

	private Integer id;
	private String code;
	private String eventName;
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_EVENT")
	@TableGenerator(name="T_EVENT", table="M_SEQUENCE",
					pkColumnName="SEQUENCE_NAME", pkColumnValue="T_EVENT_ID",
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
	@Column(name="EVENT_NAME")
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	

}
