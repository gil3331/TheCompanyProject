package kr.co.uclick.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomUserRepositoryImpl implements CustomUserRepository {

	private static final Logger logger = LoggerFactory.getLogger(CustomUserRepositoryImpl.class);

	@Override
	public void doUser(String name) {
		logger.debug("doUser : {}, {}", name, 1);
	}

}
