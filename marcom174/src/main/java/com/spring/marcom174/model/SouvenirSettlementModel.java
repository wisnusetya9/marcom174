package com.spring.marcom174.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="T_SOUVENIR_SETTLEMENT")
public class SouvenirSettlementModel {
	
	private Integer id;
	private String code;
	private String type;
	private Integer tEventId;
	private EventModel eventModel;
	private Integer receivedBy;
	private UserModel receivedByUser;
	private Date settlementDate;
	
	//Transaksi
	private Integer requestBy;
	private UserModel requestByUser;
	private Date request_date;
	private Integer approvedBy;
	private UserModel approvedByUser;
	private Date approvedDate;
	private Date dueDate;
	private String note;
	private Integer status;
	private String rejectReason;
	
	//Auditrail----------
	private Integer isDelete;
	private Integer createdBy;
	private UserModel createdByUser;
	private Date createdDate;
	private Integer updatedBy;
	private UserModel updatedByUser;
	private Date updatedDate;
	
	//-----join detail
	private List<SouvenirSettlementDetailModel> souvenirSettlementDetailModel;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_SOUVENIR_SETTLEMENT")
	@TableGenerator(name="T_SOUVENIR_SETTLEMENT", table="M_SEQUENCE",
					pkColumnName="SEQUENCE_NAME", pkColumnValue="T_SOUVENIR_SETTLEMENT_ID",
					valueColumnName="SEQUENCE_VALUE",allocationSize=1, initialValue=0)
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
	@Column(name="TYPE")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="EVENT_ID")
	public Integer gettEventId() {
		return tEventId;
	}
	public void settEventId(Integer tEventId) {
		this.tEventId = tEventId;
	}
	@ManyToOne
	@JoinColumn(name="EVENT_ID", nullable=true, updatable=false, insertable=false)
	public EventModel getEventModel() {
		return eventModel;
	}
	public void setEventModel(EventModel eventModel) {
		this.eventModel = eventModel;
	}
	@Column(name="RECEIVED_BY")
	public Integer getReceivedBy() {
		return receivedBy;
	}
	public void setReceivedBy(Integer receivedBy) {
		this.receivedBy = receivedBy;
	}
	@ManyToOne
	@JoinColumn(name="RECEIVED_BY", nullable=true, updatable=false, insertable=false)
	public UserModel getReceivedByUser() {
		return receivedByUser;
	}
	public void setReceivedByUser(UserModel receivedByUser) {
		this.receivedByUser = receivedByUser;
	}
	@Column(name="SETTLEMENT_DATE")
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	@Column(name="REQUEST_BY")
	public Integer getRequestBy() {
		return requestBy;
	}
	public void setRequestBy(Integer requestBy) {
		this.requestBy = requestBy;
	}
	@ManyToOne
	@JoinColumn(name="REQUEST_BY", nullable=true, updatable=false, insertable=false)
	public UserModel getRequestByUser() {
		return requestByUser;
	}
	public void setRequestByUser(UserModel requestByUser) {
		this.requestByUser = requestByUser;
	}
	@Column(name="REQUEST_DATE")
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}
	@Column(name="APPROVED_BY")
	public Integer getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}
	@ManyToOne
	@JoinColumn(name="APPROVED_BY", nullable=true, updatable=false, insertable=false)
	public UserModel getApprovedByUser() {
		return approvedByUser;
	}
	public void setApprovedByUser(UserModel approvedByUser) {
		this.approvedByUser = approvedByUser;
	}
	@Column(name="APPROVED_DATE")
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	@Column(name="NOTE")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Column(name="STATUS")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name="REJECT_REASON")
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	@Column(name="IS_DELETE")
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	@Column(name="CREATED_BY")
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	@ManyToOne
	@JoinColumn(name="CREATED_BY", nullable=true, updatable=false, insertable=false)
	public UserModel getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(UserModel createdByUser) {
		this.createdByUser = createdByUser;
	}
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Column(name="UPDATED_BY")
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	@ManyToOne
	@JoinColumn(name="UPDATED_BY", nullable=true, updatable=false, insertable=false)
	public UserModel getUpdatedByUser() {
		return updatedByUser;
	}
	public void setUpdatedByUser(UserModel updatedByUser) {
		this.updatedByUser = updatedByUser;
	}
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name="DUE_DATE")
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="souvenirSettlementModel")
	public List<SouvenirSettlementDetailModel> getSouvenirSettlementDetailModel() {
		return souvenirSettlementDetailModel;
	}
	public void setSouvenirSettlementDetailModel(List<SouvenirSettlementDetailModel> souvenirSettlementDetailModel) {
		this.souvenirSettlementDetailModel = souvenirSettlementDetailModel;
	}

	
	
}
