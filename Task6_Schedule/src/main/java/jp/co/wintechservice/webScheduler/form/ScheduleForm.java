package jp.co.wintechservice.webScheduler.form;

public class ScheduleForm {

    private String User;

    private String startYear;
    private String startMonth;
    private String startDay;
    private String startOclock;
    private String startMinute;

    private String endYear;
    private String endMonth;
    private String endDay;
    private String endOclock;
    private String endMinute;

    private String title;

    private String description;

    private String note;

    private String insertUser;


    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getStartOclock() {
        return startOclock;
    }

    public void setStartOclock(String startOclock) {
        this.startOclock = startOclock;
    }

    public String getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(String startMinute) {
        this.startMinute = startMinute;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getEndOclock() {
        return endOclock;
    }

    public void setEndOclock(String endOclock) {
        this.endOclock = endOclock;
    }

    public String getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(String endMinute) {
        this.endMinute = endMinute;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

}
