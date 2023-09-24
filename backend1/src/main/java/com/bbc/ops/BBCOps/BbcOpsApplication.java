package com.bbc.ops.BBCOps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bbc.ops")
public class BbcOpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbcOpsApplication.class, args);
	}

}
