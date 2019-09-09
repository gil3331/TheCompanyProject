package kr.co.uclick.repository;

import java.util.List;

import javax.lang.model.element.Name;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import kr.co.uclick.entity.User;

public interface UserRepository
		extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, CustomUserRepository {

	public List<User> findUserByName(String name);
			
	public List<User> findUsersById(Long id);
	
		 
}
