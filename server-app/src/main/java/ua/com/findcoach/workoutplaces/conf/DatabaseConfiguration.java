package ua.com.findcoach.workoutplaces.conf;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("ua.com.findcoach.workoutplaces.repository")
public class DatabaseConfiguration {

    @Autowired
    Environment environment;


    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.show_sql", "true");
                setProperty("hibernate.hbm2ddl.auto", "validate");
                setProperty("hibernate.physical_naming_strategy", "ua.com.findcoach.workoutplaces.utils.CamelCaseNamingStrategy");
                setProperty("hibernate.enable_lazy_load_no_trans", "true");
                setProperty("hibernate.id.new_generator_mappings", "false");
            }
        };
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws Exception {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ua.com.findcoach.workoutplaces.domain");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(hibernateProperties());
        factory.afterPropertiesSet();


        return factory.getObject();
    }

    @Bean
    public DataSource dataSource() throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }

}
