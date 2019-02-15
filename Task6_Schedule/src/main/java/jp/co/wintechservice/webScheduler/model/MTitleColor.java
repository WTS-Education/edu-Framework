package jp.co.wintechservice.webScheduler.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the m_title_color database table.
 * 
 */
@Entity
@Table(name="m_title_color")
@NamedQuery(name="MTitleColor.findAll", query="SELECT m FROM MTitleColor m")
public class MTitleColor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="title_color_id")
	private Integer titleColorId;

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

	@Column(name="title_color_code")
	private String titleColorCode;

	@Column(name="title_color_tag")
	private String titleColorTag;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user")
	private Integer updateUser;

	public MTitleColor() {
	}

	public Integer getTitleColorId() {
		return this.titleColorId;
	}

	public void setTitleColorId(Integer titleColorId) {
		this.titleColorId = titleColorId;
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

	public String getTitleColorCode() {
		return this.titleColorCode;
	}

	public void setTitleColorCode(String titleColorCode) {
		this.titleColorCode = titleColorCode;
	}

	public String getTitleColorTag() {
		return this.titleColorTag;
	}

	public void setTitleColorTag(String titleColorTag) {
		this.titleColorTag = titleColorTag;
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