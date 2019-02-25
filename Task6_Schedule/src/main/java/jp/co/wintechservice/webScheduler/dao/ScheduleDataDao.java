package jp.co.wintechservice.webScheduler.dao;

import java.util.List;

public interface ScheduleDataDao<S> {
    public List<S> getAllEntity();
    public List<S> findByField(String field, String find);
    public void addEntity(S entity);
    public void updateEntity(S entity);
    public void removeEntity(S data);
    public void removeEntity(Integer id);
}
