package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic 메서드가 호출되었습니다!");
	}
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		return "ex01";
	}
	// http://localhost/sample/ex02?name=jangnara&age=21
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age );
		return "ex02";		
	}
	// http://localhost/sample/ex02List?ids=111&ids=222&ids=333
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: " + ids);
		return "ex02List";
	}
	// http://localhost/sample/ex03?title=Nice day&dueDate=2023/05/11
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : " + todo);
		return "ex03";
	
	}
	// http://localhost/sample/ex04?name=jangnara&age=33&page=9
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: " + dto);
		log.info("page : " + page);
		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05 URL이 실행되었습니다.");
	}

//	@GetMapping("/ex05")
//	public String ex05() {
//		log.info("/ex05 URL이 실행되었습니다.");
//		return "ex05";
//	}

	@GetMapping("/ex06_string")
	public String ex06_string() {
		log.info("/ex06_string URL이 실행되었습니다.");
		return "ex06";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06 실행확인");
		SampleDTO dto = new SampleDTO();
		dto.setAge(21);
		dto.setName("김다미");
		return dto;
	}

}











