package com.spring.marcom174.model;

import java.util.Date;

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
@Table(name="T_SOUVENIR_SETTLEMENT_DETAIL")
public class SouvenirSettlementDetailModel {

	private Integer id;
	private Integer tSouvenirSettlementId;
	private SouvenirSettlementModel souvenirSettlementModel;
	private Integer mSouvenirId;
	private SouvenirModel souvenirModel;
	private Integer qty;
	private Integer qtySettlement;
	private String note;
	
	//Auditrail
	private Integer isDelete;
	private Integer createdBy;
	private UserModel createdByUser;
	private Date createdDate;
	private Integer updatedBy;
	private UserModel updatedByUser;
	private Date updatedDate;
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_SOUVENIR_SETTLEMENT_DETAIL")
	@TableGenerator(name="T_SOUVENIR_SETTLEMENT_DETAIL", table="M_SEQUENCE",
					pkColumnName="SEQUENCE_NAME", pkColumnValue="T_SOUVENIR_SETTLEMENT_DETAIL_ID",
					valueColumnName="SEQUENCE_VALUE",allocationSize=1,initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="T_SOUVENIR_SETTLEMENT_ID")
	public Integer gettSouvenirSettlementId() {
		return tSouvenirSettlementId;
	}
	public void settSouvenirSettlementId(Integer tSouvenirSettlementId) {
		this.tSouvenirSettlementId = tSouvenirSettlementId;
	}
	@ManyToOne
	@JoinColumn(name="T_SOUVENIR_SETTLEMENT_ID", nullable=true, updatable=false, insertable=false)
	public SouvenirSettlementModel getSouvenirSettlementModel() {
		return souvenirSettlementModel;
	}
	public void setSouvenirSettlementModel(SouvenirSettlementModel souvenirSettlementModel) {
		this.souvenirSettlementModel = souvenirSettlementModel;
	}
	@Column(name="M_SOUVENIR_ID")
	public Integer getmSouvenirId() {
		return mSouvenirId;
	}
	public void setmSouvenirId(Integer mSouvenirId) {
		this.mSouvenirId = mSouvenirId;
	}
	@ManyToOne
	@JoinColumn(name="M_SOUVENIR_ID", nullable=true, updatable=false, insertable=false)
	public SouvenirModel getSouvenirModel() {
		return souvenirModel;
	}
	public void setSouvenirModel(SouvenirModel souvenirModel) {
		this.souvenirModel = souvenirModel;
	}
	
	@Column(name="QTY")
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	@Column(name="QTY_SETTLEMENT")
	public Integer getQtySettlement() {
		return qtySettlement;
	}
	public void setQtySettlement(Integer qtySettlement) {
		this.qtySettlement = qtySettlement;
	}
	@Column(name="NOTE")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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

	
}
