package com.uhutu.zoodata.z.bean;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.zoocom.define.DefineZooCom;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryPrimary", transactionManagerRef = "transactionManagerPrimary", basePackages = {
		DefineZooCom.PACKET_BASE_SCAN,"com.uhutu.dcom" }) // 设置dao（repo）所在位置
public class RepositoryPrimaryConfig {

	private Logger logger = LoggerFactory.getLogger(RepositoryPrimaryConfig.class);

	@Autowired
	private JpaProperties jpaProperties;

	@Bean(name = "primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix = "zoodata.primary.datasource", ignoreUnknownFields = true, locations = "classpath:config-zoodata.properties")
	public DataSource primaryDataSource() {
		logger.info("init dataSource");

		return DataSourceBuilder.create().build();
	}

	@Bean(name = "entityManagerFactoryPrimary")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(primaryDataSource()).properties(getVendorProperties(primaryDataSource()))
				.packages(DefineZooCom.PACKET_BASE_SCAN,"com.uhutu.dcom").persistenceUnit("primaryPersistenceUnit").build();
	}

	@Bean(name = "entityManagerPrimary")
	@Primary
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
	}

	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);
	}

	@Bean(name = "transactionManagerPrimary")
	@Primary
	PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
	}

}
