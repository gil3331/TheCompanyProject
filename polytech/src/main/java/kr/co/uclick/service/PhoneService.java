package kr.co.uclick.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.co.uclick.entity.Phone;

import kr.co.uclick.repository.PhoneRepository;
//주 처리기능을 담당하는 페이지이다.
@Service//Service영역임을 선언한다.
@Transactional//이 선언을 통해서 트랜잭션을 제어한다.
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;//이 페이지에서 sampleRepository를 자동 연결해준다.


	@Transactional(readOnly = true)//트랜잭션 제어를 통해 읽기기능만을 부여함.
	public List<Phone> findAll() {//조건에 상관없이 모든것을 조회화는 영역(?)
		return phoneRepository.findAll();
	}
	
	@Transactional(readOnly = true)//트랜잭션 제어를 통해 읽기기능만을 부여함.
	public List<Phone> findPhonesByNumberContaining(String number) {//조건에 상관없이 모든것을 조회화는 영역(?)
		return phoneRepository.findPhonesByNumberContaining(number);
	}

	public void save(Phone phone) {//아마도 데이터 insert 영역(?)
		phoneRepository.save(phone);
	}
	
	public void delete(Long phoneId) {//이후 데이터 delete를 위해서 delete기능을 가진 페이지를 호출하면, 사용되는 영역
		phoneRepository.deleteById(phoneId);
	}
	
	
	@Transactional(readOnly=true)
	public List<Phone> findPhonesByPhoneId(Long phoneId){//id값을 기준으로 조회하는 영역 return
		return phoneRepository.findPhonesByPhoneId(phoneId);
	}
	
	
}
