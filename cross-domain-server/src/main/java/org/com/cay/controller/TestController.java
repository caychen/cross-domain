package org.com.cay.controller;

import org.com.cay.entity.User;
import org.com.cay.vo.ResultBean;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Cay on 2018/6/8.
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/get1")
	public ResultBean get1(){
		System.out.println("TestController.get1()...");
		return new ResultBean("get1 ok");
	}

	@RequestMapping("/postJson")
	public ResultBean postJson(@RequestBody User user){
		System.out.println("TestController.postJson()...");

		return new ResultBean("postJson: " + user.getName());
	}

	@GetMapping("/getCookie")
	public ResultBean getCookie(@CookieValue("cookie")String cookie){
		System.out.println("TestController.getCookie()...");
		return new ResultBean("getCookie: " + cookie);
	}

	@GetMapping("/getHeader")
	public ResultBean getHeader(@RequestHeader("x-header1") String header1, @RequestHeader("x-header2")String header2){
		System.out.println("TestController.getHeader()...");
		return new ResultBean("getHeader: " + header1 + "-" + header2);
	}
}
