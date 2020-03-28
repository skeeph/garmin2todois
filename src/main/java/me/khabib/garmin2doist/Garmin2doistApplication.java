package me.khabib.garmin2doist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Garmin2doistApplication {

    public static void main(String[] args) {
        SpringApplication.run(Garmin2doistApplication.class, args);
    }

}
