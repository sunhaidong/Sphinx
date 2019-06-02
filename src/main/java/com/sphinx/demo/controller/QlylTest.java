package com.sphinx.demo.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("qlyl")
public class QlylTest {

	@Cacheable(value = "role", key = "#id")
	@RequestMapping("test")
	public String Test(String id) {
		return "test";
	}
}
