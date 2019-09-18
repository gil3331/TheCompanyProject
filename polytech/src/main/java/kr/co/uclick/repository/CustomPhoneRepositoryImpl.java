package kr.co.uclick.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomPhoneRepositoryImpl implements CustomPhoneRepository {

	private static final Logger logger = LoggerFactory.getLogger(CustomPhoneRepositoryImpl.class);

	@Override
	public void doPhone(String number) {
		logger.debug("doPhone : {}, {}", number, 1);
	}

}
