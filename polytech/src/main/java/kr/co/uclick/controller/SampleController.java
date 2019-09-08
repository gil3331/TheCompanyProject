package kr.co.uclick.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.uclick.entity.Sample;
import kr.co.uclick.service.SampleService;

@Controller
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@Autowired
	private SampleService sampleService; //sampleService를 자동으로 연결해준다.
	//GetMapping이란 RequestMapping(method=requestMethod.get)의 바로가기 형태이다.
	@GetMapping(value = "list.html")//list.html을 호출하였을 때(list=전체 사용자 리스트를 구현하려는 페이지)
	public String Ulist(Model model) {
		model.addAttribute("users", sampleService.findAll());//sampleService.findAll()에 users라는 이름을 부여하여 사용한다.
		return "list";//list값을 돌려준다.
	}
		
	@GetMapping(value = "newForm.html")//newForm.html을 호출하면(아마도 create 테이블용 페이지)
	public String newForm(Model model) {
		return "newForm";//newForm을 돌려준다.
	}

	@GetMapping(value = "editForm.html")//editForm.html을 호출하면 (데이터 값 update 페이지)
	public String editForm(Long sampleId, Model model) {
		sampleService.findById(sampleId);//sampleservice에서 sampleId라는 id를 찾아준다.
		return "editForm";//editForm을 돌려준다.
	}

	@PostMapping(value = "save.html")//save.html을 호출하면 (데이터 insert 페이지)
	public String save(Sample sample, Model model) {
		return "redirect:list.html";
	}

	@DeleteMapping(value = "delete.html")//delete.html을 호출하면 (데이터 delete 페이지)
	public String delete(Long sampleId, Model model) {
		return "redirect:list.html";
	}

	@GetMapping(value = "sample.html")//sample.html을 호출하면,
	public String sample(String name, Sample sample, Model model) {

		logger.debug("sample name : {}", name);//html을 호출하며 받아진 name을 디버그테스트한다.
		logger.debug("Sample.name : {}", sample.getName());//html을 호출하며 받아진 sample이란 부분을 디버그테스트한다.

		model.addAttribute("samples", sampleService.findAll());//sampleservice.findall()에 samples라는 이름을 부여하여 사용한다.
		model.addAttribute("sample", sample);//sample(후자)에 sample(전자)이란 이름을 부여하여 사용한다.
		model.addAttribute("findSampleByName", sampleService.findSampleByName(name));//sampleservice에서 name이란 이름이 들어간 부분을 찾아서 findsamplebyname이란 이름을 부여하여 사용한다.
		return "sample";//sample을 돌려준다.
	}
}
