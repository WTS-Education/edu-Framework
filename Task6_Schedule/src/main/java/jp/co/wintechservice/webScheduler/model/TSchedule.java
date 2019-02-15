package jp.co.wintechservice.webScheduler.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_schedule database table.
 * 
 */
@Entity
@Table(name="t_schedule")
@NamedQuery(name="TSchedule.findAll", query="SELECT t FROM TSchedule t")
public class TSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="schedule_id")
	private Integer scheduleId;

	@Column(name="delete_date")
	private Timestamp deleteDate;

	@Column(name="delete_flg")
	private String deleteFlg;

	@Column(name="delete_user")
	private Integer deleteUser;

	private String description;

	@Column(name="edit_authority")
	private Integer editAuthority;

	@Column(name="end_timestamp")
	private Timestamp endTimestamp;

	@Column(name="insert_date")
	private Timestamp insertDate;

	@Column(name="insert_user")
	private Integer insertUser;

	private String note;

	@Column(name="release_flg")
	private String releaseFlg;

	@Column(name="start_timestamp")
	private Timestamp startTimestamp;

	private String title;

	@Column(name="title_color")
	private Integer titleColor;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user")
	private Integer updateUser;

	public TSchedule() {
	}

	public Integer getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEditAuthority() {
		return this.editAuthority;
	}

	public void setEditAuthority(Integer editAuthority) {
		this.editAuthority = editAuthority;
	}

	public Timestamp getEndTimestamp() {
		return this.endTimestamp;
	}

	public void setEndTimestamp(Timestamp endTimestamp) {
		this.endTimestamp = endTimestamp;
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

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getReleaseFlg() {
		return this.releaseFlg;
	}

	public void setReleaseFlg(String releaseFlg) {
		this.releaseFlg = releaseFlg;
	}

	public Timestamp getStartTimestamp() {
		return this.startTimestamp;
	}

	public void setStartTimestamp(Timestamp startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getTitleColor() {
		return this.titleColor;
	}

	public void setTitleColor(Integer titleColor) {
		this.titleColor = titleColor;
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