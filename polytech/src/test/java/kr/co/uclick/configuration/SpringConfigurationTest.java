package kr.co.uclick.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.uclick.entity.Sample;
import kr.co.uclick.entity.User;
import kr.co.uclick.entity.Phone;
import kr.co.uclick.service.SampleService;
import kr.co.uclick.service.UserService;
import kr.co.uclick.service.PhoneService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringConfigurationTest {

	@Autowired
	UserService userService;

	@Test
	public void test() {
		User user = new User();
		user.setName("park");
		user.setdepartment("영업부");
		user.setregistDate("2019-09-20");
		
		userService.findAll();
	}

}
