package com.ramazaniperlik;

import com.ramazaniperlik.DB.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Database.fill();
        SpringApplication.run(Main.class,args);
    }
}
