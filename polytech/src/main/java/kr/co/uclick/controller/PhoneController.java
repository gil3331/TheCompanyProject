package kr.co.uclick.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.uclick.entity.Phone;
import kr.co.uclick.entity.User;
import kr.co.uclick.service.PhoneService;
import kr.co.uclick.service.UserService;


@Controller
public class PhoneController {

	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);

	@Autowired
	private PhoneService phoneService; //sampleService를 자동으로 연결해준다.
	
	
	//GetMapping이란 RequestMapping(method=requestMethod.get)의 바로가기 형태이다.
	@GetMapping(value = "Phonelist.html")//list.html을 호출하였을 때(list=전체 사용자 리스트를 구현하려는 페이지)
	public String Phonelist(Model model) {
		model.addAttribute("phones", phoneService.findAll());//sampleService.findAll()에 users라는 이름을 부여하여 사용한다.
			return "Phonelist";//list값을 돌려준다.
	}
	
	@GetMapping(value = "PhoneLike.html")//PhoneLike.html을 호출하였을 때(특정 조건으로 데이터를 조회하는 페이지)
	public String PhoneLike(@RequestParam(value = "number") String number, Model model) {
		System.out.println(number);
		model.addAttribute("phone", phoneService.findPhonesByNumberContaining(number));//number변수 값을 기준으로 데이터를 조회하는 메서드
		return "PhoneLike";//list값을 돌려준다.
	}
	
	@GetMapping(value = "newPhone.html")//newPhone.html을 호출하면(user.id로 들어온 내용에 대해 신규 Phone을 작성하는 form)
	public String newPhone(@RequestParam (value="user.id") String id, Model model) {
				model.addAttribute("id",id);
				return "newPhone";//newPhone을 돌려준다.
	}
	
	@GetMapping(value = "Phoneinsert.html")//Phoneinsert.html을 호출하면(newPhone에서 작성된 값을 받아 DB에 저장하는 페이지)
	public String Phoneinsert(Phone phone, Model model) {
			phoneService.save(phone);
			return "Phoneinsert";//Phoneinsert을 돌려준다.
	}
	
	
	@GetMapping(value = "Phoneupdate.html")//Phoneupdate.html을 호출하면 (수정 form을 구현하는 페이지)
	public String save(Long phoneId, Model model) {
	model.addAttribute("phone",phoneService.findPhonesByPhoneId(phoneId));
	return "Phoneupdate";
	}
	 
	@PostMapping(value = "PhoneupdateDB.html")//PhoneupdateDB.html을 호출하면 (Phoneupdate에서 받은 값을 DB에 저장하는 페이지)
	public String saveDB(Phone phone, Model model) {
		System.out.println(phone.getphoneId());
		System.out.println(phone.getNumber());
		System.out.println(phone.getUser());
		phoneService.save(phone);
		return "PhoneupdateDB";
	}
	
		
	@GetMapping(value = "Phonedelete.html")//delete.html을 호출하면 (데이터 delete 페이지)
	public String delete(Long phoneId, Model model) {
		phoneService.delete(phoneId);
		return "redirect:Phonelist.html";
	}
	
	
}
