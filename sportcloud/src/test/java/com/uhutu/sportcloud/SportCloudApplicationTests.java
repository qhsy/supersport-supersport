package com.uhutu.sportcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uhutu.dcom.user.entity.UcUserinfo;
import com.uhutu.dcom.user.service.UserServiceFactory;
import com.uhutu.sportcloud.SportCloudApplication;
import com.uhutu.zoocom.root.RootSimpleApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan({"com.uhutu.**.z.","com.uhutu.sportcloud","com.uhutu.sportcenter","com.uhutu.dcom"})
@SpringApplicationConfiguration(classes = SportCloudApplication.class)
public class SportCloudApplicationTests extends RootSimpleApplication {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Test
	public void contextLoads() {
		
		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().query("123");
		
		System.out.println(ucUserinfo.getZa());
		
	}

}
