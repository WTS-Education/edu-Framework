package jp.co.wintechservice.webScheduler.form;

public class ScheduleForm {

    private String User;

    private int startYear;
    private int startMonth;
    private int startDay;
    private int startOclock;
    private int startMinute;

    private int endYear;
    private int endMonth;
    private int endDay;
    private int endOclock;
    private int endMinute;

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

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartOclock() {
        return startOclock;
    }

    public void setStartOclock(int startOclock) {
        this.startOclock = startOclock;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndOclock() {
        return endOclock;
    }

    public void setEndOclock(int endOclock) {
        this.endOclock = endOclock;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
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
