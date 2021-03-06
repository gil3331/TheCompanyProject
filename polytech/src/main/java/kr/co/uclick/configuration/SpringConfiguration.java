package kr.co.uclick.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ignite.cache.hibernate.HibernateRegionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration//클래스에 이 어노테이션이 붙어 있으면 스프링은 해당 클래스를 Java config로 간주한다.
@ImportResource(locations = "classpath:applicationContext-ignite.xml")//ignite에 있는 내용을 import해온다.
@ComponentScan({ "kr.co.uclick.service" })//컴포넌트 검색기능을 가진 어노테이션이다
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)//트랜잭션 메니저로 aspectj를 사용
@EnableSpringConfigured
@EnableJpaRepositories(basePackages = "kr.co.uclick.repository")//jpa레퍼지토리로 해당 패키지를 씀
public class SpringConfiguration {

	@Bean
	@Primary
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");//jdbc 드라이버를 써서 datasource driver를 사용
		dataSource.setUrl("jdbc:mysql://35.189.155.41:3306/kopo15?characterEncoding=utf8&serverTimezone=UTC");//서버 url부여
		dataSource.setUsername("root");//서버 접속시 아이디
		dataSource.setPassword("asdf1234");//서버 접속시 패스워드
		return dataSource;
	}

	@Bean
	@DependsOn("igniteSystem")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("kr.co.uclick.entity");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	@Primary
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	public Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
		properties.setProperty(AvailableSettings.FORMAT_SQL, Boolean.TRUE.toString());
		properties.setProperty(AvailableSettings.SHOW_SQL, Boolean.TRUE.toString());
		properties.setProperty(AvailableSettings.DIALECT, MySQL5Dialect.class.getName());

		properties.setProperty(AvailableSettings.STATEMENT_BATCH_SIZE, "1000");

		properties.setProperty(AvailableSettings.USE_SECOND_LEVEL_CACHE, Boolean.TRUE.toString());
		properties.setProperty(AvailableSettings.USE_QUERY_CACHE, Boolean.TRUE.toString());
		properties.setProperty(AvailableSettings.GENERATE_STATISTICS, Boolean.FALSE.toString());
		properties.setProperty(AvailableSettings.CACHE_REGION_FACTORY, HibernateRegionFactory.class.getName());

		properties.setProperty("org.apache.ignite.hibernate.ignite_instance_name", "cafe-grid");
		properties.setProperty("org.apache.ignite.hibernate.default_access_type", "NONSTRICT_READ_WRITE");

		properties.setProperty(AvailableSettings.PHYSICAL_NAMING_STRATEGY,
				CustomPhysicalNamingStrategyStandardImpl.class.getName());
		return properties;
	}

}
