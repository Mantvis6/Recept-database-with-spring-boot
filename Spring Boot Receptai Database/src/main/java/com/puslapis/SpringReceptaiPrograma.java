package com.puslapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.puslapis.dao.entities"})
@SpringBootApplication
public class SpringReceptaiPrograma {

    public static void main(String[] args) {SpringApplication.run(SpringReceptaiPrograma.class, args); }
}
