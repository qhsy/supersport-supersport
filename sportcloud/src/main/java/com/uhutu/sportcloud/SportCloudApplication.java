package com.uhutu.sportcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uhutu.zoocom.root.RootSimpleApplication;

@SpringBootApplication
public class SportCloudApplication extends RootSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportCloudApplication.class, args);
	}
}
