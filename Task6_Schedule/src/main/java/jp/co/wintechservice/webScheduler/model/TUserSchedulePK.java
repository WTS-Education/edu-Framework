package jp.co.wintechservice.webScheduler.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_user_schedule database table.
 * 
 */
@Embeddable
public class TUserSchedulePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="schedule_id")
	private Integer scheduleId;

	@Column(name="schedule_user")
	private Integer scheduleUser;

	public TUserSchedulePK() {
	}
	public Integer getScheduleId() {
		return this.scheduleId;
	}
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Integer getScheduleUser() {
		return this.scheduleUser;
	}
	public void setScheduleUser(Integer scheduleUser) {
		this.scheduleUser = scheduleUser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TUserSchedulePK)) {
			return false;
		}
		TUserSchedulePK castOther = (TUserSchedulePK)other;
		return 
			this.scheduleId.equals(castOther.scheduleId)
			&& this.scheduleUser.equals(castOther.scheduleUser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.scheduleId.hashCode();
		hash = hash * prime + this.scheduleUser.hashCode();
		
		return hash;
	}
}