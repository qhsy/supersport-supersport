package com.uhutu.sportcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.uhutu.zoocom.root.RootSimpleApplication;

@SpringBootApplication
@ComponentScan({"com.uhutu.**.z.","com.uhutu.sportcloud","com.uhutu.sportcenter"})
public class SportCloudApplication extends RootSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportCloudApplication.class, args);
	}
}
