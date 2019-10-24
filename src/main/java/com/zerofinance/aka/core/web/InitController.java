package com.zerofinance.aka.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {

	@GetMapping("/init")
	public String init() {
		return "success";
	}
}
