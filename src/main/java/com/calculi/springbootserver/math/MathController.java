package com.calculi.springbootserver.math;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MathController {

	MathController() {
	}

	@GetMapping("/")
	public String hello() {
		return "Hello CloudBees!";
	}

	@GetMapping("/add/{a}/{b}")
	Double add(@PathVariable Double a, @PathVariable Double b) {
		return a + b;
	}

	@GetMapping("/sub/{a}/{b}")
	Double sub(@PathVariable Double a, @PathVariable Double b) {
		return a - b;
	}

	@GetMapping("/mult/{a}/{b}")
	Double mult(@PathVariable Double a, @PathVariable Double b) {
		return a * b;
	}

	@GetMapping("/div/{a}/{b}")
	Double div(@PathVariable Double a, @PathVariable Double b) {
		return a / b;
	}

	@GetMapping("/sqrt/{a}")
	Double sqrt(@PathVariable Double a) {
		return Math.sqrt(a);
	}

	@GetMapping("/cbrt/{a}")
	Double cbrt(@PathVariable Double a) {
		return Math.cbrt(a);
	}

}
