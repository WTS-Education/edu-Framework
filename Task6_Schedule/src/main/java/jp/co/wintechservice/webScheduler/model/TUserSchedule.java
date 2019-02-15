package jp.co.wintechservice.webScheduler.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_user_schedule database table.
 * 
 */
@Entity
@Table(name="t_user_schedule")
@NamedQuery(name="TUserSchedule.findAll", query="SELECT t FROM TUserSchedule t")
public class TUserSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TUserSchedulePK id;

	@Column(name="delete_date")
	private Timestamp deleteDate;

	@Column(name="delete_flg")
	private String deleteFlg;

	@Column(name="delete_user")
	private Integer deleteUser;

	@Column(name="insert_date")
	private Timestamp insertDate;

	@Column(name="insert_user")
	private Integer insertUser;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user")
	private Integer updateUser;

	public TUserSchedule() {
	}

	public TUserSchedulePK getId() {
		return this.id;
	}

	public void setId(TUserSchedulePK id) {
		this.id = id;
	}

	public Timestamp getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getDeleteFlg() {
		return this.deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public Integer getDeleteUser() {
		return this.deleteUser;
	}

	public void setDeleteUser(Integer deleteUser) {
		this.deleteUser = deleteUser;
	}

	public Timestamp getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public Integer getInsertUser() {
		return this.insertUser;
	}

	public void setInsertUser(Integer insertUser) {
		this.insertUser = insertUser;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

}