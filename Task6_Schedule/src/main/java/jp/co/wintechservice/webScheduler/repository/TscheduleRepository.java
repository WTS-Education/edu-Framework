package jp.co.wintechservice.webScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.wintechservice.webScheduler.model.TSchedule;

public interface TscheduleRepository extends JpaRepository<TSchedule, Integer> {

}
