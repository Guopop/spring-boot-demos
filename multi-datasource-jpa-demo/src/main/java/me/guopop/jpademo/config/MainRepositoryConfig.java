package me.guopop.jpademo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;

/**
 * @author guopop
 * @date 2021/1/9 15:27
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "mainEntityManagerFactory",
        transactionManagerRef = "mainTransactionManager",
        basePackages = {"me.guopop.jpademo.repository.main"}
)
public class MainRepositoryConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Primary
    @Bean(name = "mainDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.main")
    public DataSource mainDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mainEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(this.mainDataSource())
                .properties(getVendorProperties())
                .packages("me.guopop.jpademo.entity.main")
                .persistenceUnit("mainPersistenceUnit")
                .build();
    }

    private Map<String, ?> getVendorProperties() {
        Map<String, String> properties = jpaProperties.getProperties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return properties;
    }

    @Bean(name = "mainTransactionManager")
    public PlatformTransactionManager mainTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(mainEntityManagerFactory(builder).getObject()));
    }
}
