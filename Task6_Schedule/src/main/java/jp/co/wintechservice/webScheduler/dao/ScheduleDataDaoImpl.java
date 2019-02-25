package jp.co.wintechservice.webScheduler.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jp.co.wintechservice.webScheduler.model.TSchedule;

public class ScheduleDataDaoImpl implements ScheduleDataDao<TSchedule> {

    private EntityManager manager = null;

    public ScheduleDataDaoImpl(EntityManager manager) {
        super();
        this.manager = manager;
    }

    public List<TSchedule> getAllEntity() {
        Query query = manager.createQuery("from TSchedule");
        return query.getResultList();
    }

    public List<TSchedule> findByField(String field, String find) {
        Query query = manager.createQuery("from TSchedule where"
                + field + "='" + find + "'");
        return query.getResultList();
    }

    public void addEntity(TSchedule entity) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(entity);
        manager.flush();
        transaction.commit();
    }

    public void updateEntity(TSchedule entity) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(entity);
        manager.flush();
        transaction.commit();
    }

    public void removeEntity(TSchedule data) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.remove(data);
        manager.flush();
        transaction.commit();
    }

    public void removeEntity(Integer id) {
        TSchedule entity = manager.find(TSchedule.class, id);
        this.removeEntity(entity);
    }

}
