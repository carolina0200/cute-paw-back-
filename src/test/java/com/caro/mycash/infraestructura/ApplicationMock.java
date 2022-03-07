package com.caro.mycash.infraestructura;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.caro"})
@EnableJpaRepositories(basePackages = "com.caro")
public class ApplicationMock {

}
