package kr.co.uclick.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.uclick.entity.Phone;


public interface PhoneRepository
		extends JpaRepository<Phone, Long>, QuerydslPredicateExecutor<Phone>, CustomPhoneRepository {
		
		public List<Phone> findPhonesByPhoneId(Long phoneId);
		
		@QueryHints(@QueryHint(name="org.hibernate.cacheable",value="true"))
		public List<Phone> findPhonesByNumberContaining(String number);
}
