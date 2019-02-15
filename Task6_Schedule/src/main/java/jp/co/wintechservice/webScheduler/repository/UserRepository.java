package jp.co.wintechservice.webScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.wintechservice.webScheduler.model.MUser;

@Repository
public interface UserRepository extends JpaRepository<MUser, String> {

}
