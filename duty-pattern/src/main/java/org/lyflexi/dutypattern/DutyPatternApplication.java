package org.lyflexi.dutypattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.lyflexi.dutypattern.genericFactory.*"),
//        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.lyflexi.dutypattern.genericBuilder.*"),
})
public class DutyPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(DutyPatternApplication.class, args);
    }

}
