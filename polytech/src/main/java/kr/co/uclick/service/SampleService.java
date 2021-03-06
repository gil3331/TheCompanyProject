package kr.co.uclick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.QSample;
import kr.co.uclick.entity.Sample;
import kr.co.uclick.repository.SampleRepository;
//주 처리기능을 담당하는 페이지이다.
@Service//Service영역임을 선언한다.
@Transactional//이 선언을 통해서 트랜잭션을 제어한다.
public class SampleService {

	@Autowired
	private SampleRepository sampleRepository;//이 페이지에서 sampleRepository를 자동 연결해준다.

	public void delete(Sample entity) {//이후 데이터 delete를 위해서 delete기능을 가진 페이지를 호출하면, 사용되는 영역
		sampleRepository.delete(entity);
	}

	@Transactional(readOnly = true)//트랜잭션 제어를 통해 읽기기능만을 부여함.
	public List<Sample> findAll() {//조건에 상관없이 모든것을 조회화는 영역(?)
		return sampleRepository.findAll();
	}

	@Transactional(readOnly = true)//트랜잭션 제어를 통해 읽기기능만을 부여함.
	public List<Sample> findSampleByName(String name) {//이름을 조건으로 조회화는 영역

		sampleRepository.findAll(QSample.sample.name.eq(name));//받아온 이름을 기준으로 부분조회
		sampleRepository.doSample(name);

		return sampleRepository.findSampleByName(name);//samplerepository에서 name이란 값을 가진 이름을 찾아 리턴해준다.
	}

	public void save(Sample sample) {//아마도 데이터 insert 영역(?)
		sampleRepository.save(sample);
	}

	public void findById(Long sampleId) {//id값을 기준으로 조회하는 영역
		sampleRepository.findById(sampleId);
	}
}
