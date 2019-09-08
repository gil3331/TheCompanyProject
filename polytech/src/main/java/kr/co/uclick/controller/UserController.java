package kr.co.uclick.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.uclick.entity.User;
import kr.co.uclick.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService; //sampleService를 자동으로 연결해준다.
	//GetMapping이란 RequestMapping(method=requestMethod.get)의 바로가기 형태이다.
	@GetMapping(value = "Userlist.html")//list.html을 호출하였을 때(list=전체 사용자 리스트를 구현하려는 페이지)
	public String Userlist(Model model) {
		model.addAttribute("users", userService.findAll());//sampleService.findAll()에 users라는 이름을 부여하여 사용한다.
		return "Userlist";//list값을 돌려준다.
	}
	
	//@GetMapping(value = "newUser.html")//newForm.html을 호출하면(아마도 create 테이블용 페이지)
	//public String newUser(Model model) {
	//	return "newUser";//newForm을 돌려준다.
	//}

	//@GetMapping(value = "editForm.html")//editForm.html을 호출하면 (데이터 값 update 페이지)
	//public String editForm(Long sampleId, Model model) {
	//	userService.findById(sampleId);//sampleservice에서 sampleId라는 id를 찾아준다.
	//	return "editForm";//editForm을 돌려준다.
	//}

	//@PostMapping(value = "save.html")//save.html을 호출하면 (데이터 insert 페이지)
	//public String save(User sample, Model model) {
	//	return "redirect:list.html";
	//}

	//@DeleteMapping(value = "delete.html")//delete.html을 호출하면 (데이터 delete 페이지)
	//public String delete(Long sampleId, Model model) {
	//	return "redirect:list.html";
	//}
		
}