package jp.co.wintechservice.webScheduler.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the m_user database table.
 *
 */
@Entity
@Table(name="m_user")
@NamedQuery(name="MUser.findAll", query="SELECT m FROM MUser m")
public class MUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private Integer userId;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name="delete_date")
	private Timestamp deleteDate;

	@Column(name="delete_flg")
	private String deleteFlg;

	@Column(name="delete_user")
	private Integer deleteUser;

	@Column(name="employee_num")
	private String employeeNum;

	@Column(name="insert_date")
	private Timestamp insertDate;

	@Column(name="insert_user")
	private Integer insertUser;

	@Column(name="login_id")
	private String loginId;

	@Column(name="password")
	private String password;

	@Column(name="position")
	private String position;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user")
	private Integer updateUser;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_name_kana")
	private String userNameKana;

	public MUser() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getEmployeeNum() {
		return this.employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
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

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNameKana() {
		return this.userNameKana;
	}

	public void setUserNameKana(String userNameKana) {
		this.userNameKana = userNameKana;
	}

}