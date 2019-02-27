package jp.co.wintechservice.webScheduler.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq",sequenceName="schedule_id_seq", allocationSize=1)
	@Column(name="schedule_id", nullable=false)
	private Integer scheduleId;

	@Column(name="delete_date", nullable=true)
	private Timestamp deleteDate;

	@Column(name="delete_flg", length=1, nullable=false)
	private String deleteFlg;

	@Column(name="delete_user", nullable=true)
	private Integer deleteUser;

	@Column(name="description", nullable=true)
	private String description;

	@Column(name="edit_authority", nullable=false)
	private Integer editAuthority;

	@Column(name="end_timestamp", nullable=true)
	private Timestamp endTimestamp;

	@Column(name="insert_date", nullable=false)
	private Timestamp insertDate;

	@Column(name="insert_user", nullable=false)
	private Integer insertUser;

	@Column(name="note", nullable=true)
	private String note;

	@Column(name="release_flg", length=1, nullable=false)
	private String releaseFlg;

	@Column(name="start_timestamp", nullable=false)
	private Timestamp startTimestamp;

	@Column(name="title", length=100, nullable=false)
	private String title;

	@Column(name="title_color", nullable=true)
	private Integer titleColor;

	@Column(name="update_date", nullable=true)
	private Timestamp updateDate;

	@Column(name="update_user", nullable=true)
	private Integer updateUser;

	public TSchedule(int insertUser, Timestamp start_timestamp, Timestamp end_timestamp, String title,
	        String description, String note, String deleteFlg, int editAuthority, Timestamp insertDate, String releaseFlg) {
	    insertUser = this.insertUser;
	    start_timestamp = this.startTimestamp;
	    end_timestamp = this.endTimestamp;
	    title = this.title;
	    description = this.description;
	    note = this.note;
	    deleteFlg = this.deleteFlg;
	    editAuthority = this.editAuthority;
	    insertDate = this.insertDate;
	    releaseFlg = this.releaseFlg;
	}

	public TSchedule() {

	}

	/**
	 * scheduleId getter
	 * @return scheduleId
	 */
	public Integer getScheduleId() {
		return this.scheduleId;
	}

	/**
	 * scheduleId setter
	 * @param scheduleId
	 */
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
	 * deleteDate getter
	 * @return deleteDate
	 */
	public Timestamp getDeleteDate() {
		return this.deleteDate;
	}

	/**
	 * deleteDate setter
	 * @param deleteDate
	 */
	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
	}

	/**
	 * deleteFlg getter
	 * @return deleteFlg
	 */
	public String getDeleteFlg() {
		return this.deleteFlg;
	}

	/**
	 * deleteFlg setter
	 * @param deleteFlg
	 */
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	/**
	 * deleteUser getter
	 * @return deleteUser
	 */
	public Integer getDeleteUser() {
		return this.deleteUser;
	}

	/**
	 * deleteUser setter
	 * @param deleteUser
	 */
	public void setDeleteUser(Integer deleteUser) {
		this.deleteUser = deleteUser;
	}

	/**
	 * description getter
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * description setter
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * editAuthority getter
	 * @return editAuthority
	 */
	public Integer getEditAuthority() {
		return this.editAuthority;
	}

	/**
	 * editAuthority setter
	 * @param editAuthority
	 */
	public void setEditAuthority(Integer editAuthority) {
		this.editAuthority = editAuthority;
	}

	/**
	 * endTimeStamp getter
	 * @return endTimeStamp
	 */
	public Timestamp getEndTimestamp() {
		return this.endTimestamp;
	}

	/**
	 * endTimeStamp setter
	 * @param endTimestamp
	 */
	public void setEndTimestamp(Timestamp endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	/**
	 * insertDate getter
	 * @return insertDate
	 */
	public Timestamp getInsertDate() {
		return this.insertDate;
	}

	/**
	 * insertDate setter
	 * @param insertDate
	 */
	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * insertUser getter
	 * @return insertUser
	 */
	public Integer getInsertUser() {
		return this.insertUser;
	}

	/**
	 * insertUser setter
	 * @param insertUser
	 */
	public void setInsertUser(Integer insertUser) {
		this.insertUser = insertUser;
	}

	/**
	 * note getter
	 * @return note
	 */
	public String getNote() {
		return this.note;
	}

	/**
	 * note setter
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * releaseFlg getter
	 * @return releaseFlg
	 */
	public String getReleaseFlg() {
		return this.releaseFlg;
	}

	/**
	 * releaseFlg setter
	 * @param releaseFlg
	 */
	public void setReleaseFlg(String releaseFlg) {
		this.releaseFlg = releaseFlg;
	}

	/**
	 * startTimeStamp getter
	 * @return timeStamp
	 */
	public Timestamp getStartTimestamp() {
		return this.startTimestamp;
	}

	/**
	 * startTimeStamp setter
	 * @param startTimestamp
	 */
	public void setStartTimestamp(Timestamp startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	/**
	 * title getter
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * title setter
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * titleColor getter
	 * @return titleColor
	 */
	public Integer getTitleColor() {
		return this.titleColor;
	}

	/**
	 * titleColor setter
	 * @param titleColor
	 */
	public void setTitleColor(Integer titleColor) {
		this.titleColor = titleColor;
	}

	/**
	 * updateDate getter
	 * @return updateDate
	 */
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * updateDate setter
	 * @param updateDate
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * updateUser getter
	 * @return updateUser
	 */
	public Integer getUpdateUser() {
		return this.updateUser;
	}

	/**
	 * updateUser setter
	 * @param updateUser
	 */
	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

}