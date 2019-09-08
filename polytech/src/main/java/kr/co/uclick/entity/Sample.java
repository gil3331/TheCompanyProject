package kr.co.uclick.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Sample {

	@Id//이곳의 프로퍼티가 테이블의 주키임을 나타내는 어노테이션
	@TableGenerator(name = "sample")//키 생성 전용 table을 만들어서 이를 시퀀스처럼 사용하는 어노테이션
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sample")//주키의 값을 위한 자동 생성 전략을 명시하는데 어노테이션
	//테이블 속성은 id, name, number로 구분됨
	private Long id;

	private String name;

	private int number;
	//하단은 get/set으로 구분 되는 부분
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
