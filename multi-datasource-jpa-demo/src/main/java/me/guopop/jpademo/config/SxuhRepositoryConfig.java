package me.guopop.jpademo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
 * @date 2021/1/9 14:53
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "sxuhEntityManagerFactory",
        transactionManagerRef = "sxuhTransactionManager",
        basePackages = {"me.guopop.jpademo.repository.sxuh"}
)
public class SxuhRepositoryConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = "sxuhDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sxuh")
    public DataSource sxuhDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sxuhEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sxuhEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(this.sxuhDataSource())
                .properties(getVendorProperties())
                .packages("me.guopop.jpademo.entity.sxuh")
                .persistenceUnit("sxuhPersistenceUnit")
                .build();
    }

    private Map<String, ?> getVendorProperties() {
        Map<String, String> properties = jpaProperties.getProperties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
        return properties;
    }

    @Bean(name = "sxuhTransactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(sxuhEntityManagerFactory(builder).getObject()));
    }
}
