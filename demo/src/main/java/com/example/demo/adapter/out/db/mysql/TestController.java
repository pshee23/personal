package com.example.demo.adapter.out.db.mysql;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {

	private final MysqlDataAdapter adapter;
	
	@GetMapping("/select")
    public String selectTest(HttpServletRequest httpServletRequest){
		adapter.selectTestData();
        return "OK";
    }
	
	@GetMapping("/insert")
    public String insertTest(HttpServletRequest httpServletRequest){
		adapter.insertTestData();
        return"OK";
    }
}
