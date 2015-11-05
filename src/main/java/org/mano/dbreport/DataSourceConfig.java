package org.mano.dbreport;

import javax.annotation.PreDestroy;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mano.dbreport.config.DataSourceProperties;
import org.mano.dbreport.config.MyBatisProperties;
import org.mano.dbreport.dao.SectionDao;
import org.mano.dbreport.dao.impl.SectionDaoImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties({DataSourceProperties.class, MyBatisProperties.class})
@MapperScan("org.mano.dbreport.client.dao")
public class DataSourceConfig {

	@Autowired
	private DataSourceProperties dataSourceProperties;

	@Autowired
	private MyBatisProperties myBatisProperties;	
	
	@Autowired
	private DataSource dataSource;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		dataSource = new DataSource();
		dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
		dataSource.setUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUserName());
		dataSource.setPassword(dataSourceProperties.getPassword());
		dataSource.setInitialSize(dataSourceProperties.getInitialSize());
		dataSource.setMaxActive(dataSourceProperties.getMaxActive());
		dataSource.setMaxIdle(dataSourceProperties.getMaxIdle());
		dataSource.setMinIdle(dataSourceProperties.getMinIdle());
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setTypeAliasesPackage("org.mano.dbreport.entity");
		sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SectionDao sectionDaoBean() throws Exception {
		SectionDaoImpl sectionDao = new SectionDaoImpl();
		sectionDao.setSqlSessionFactory(sqlSessionFactoryBean());
		return sectionDao;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@PreDestroy
	public void close() {
		if (dataSource != null) {
			dataSource.close();
			dataSource = null;
		}
	}
}
