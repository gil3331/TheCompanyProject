package kr.co.uclick.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class Phone {

	@Id // 이곳의 프로퍼티가 테이블의 주키임을 나타내는 어노테이션
	@TableGenerator(name = "Phone") // 키 생성 전용 table을 만들어서 이를 시퀀스처럼 사용하는 어노테이션
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Phone") // 주키의 값을 위한 자동 생성 전략을 명시하는데 어노테이션
	// 테이블 속성은 id, name, number로 구분됨
	@Column(name = "phoneId")
	private Long phoneId;
	@Column(name = "number")
	private String number;

	// 하단은 get/set으로 구분 되는 부분
	
	public Long getphoneId() {
		return phoneId;
	}

	public void setphoneId(Long phoneId) {
		this.phoneId = phoneId;
	}
	
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;

	}
	


}
