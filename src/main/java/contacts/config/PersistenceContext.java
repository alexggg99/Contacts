package contacts.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("contacts.domain")
public class PersistenceContext {

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:contacts");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws ClassNotFoundException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("contacts");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        Properties jpaProterties = new Properties();
        jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        jpaProterties.put("hibernate.hbm2ddl.auto", "update");
        jpaProterties.put("hibernate.connection.characterEncoding", "utf8");
        jpaProterties.put("hibernate.show_sql", "true");
        jpaProterties.put("hibernate.hbm2ddl.import_files", "/META-INF/schema.sql");
        entityManagerFactoryBean.setJpaProperties(jpaProterties);
        return entityManagerFactoryBean;
    }

}
