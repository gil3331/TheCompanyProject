package kr.co.uclick.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;


import kr.co.uclick.entity.User;

public interface UserRepository
		extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, CustomUserRepository {

	public List<User> findUserByName(String name);
			
	public List<User> findUsersById(Long id);
	
		 
}
