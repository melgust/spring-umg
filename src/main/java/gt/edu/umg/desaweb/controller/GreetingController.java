package gt.edu.umg.desaweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
	
	@GetMapping("/hello/{name}")
	public String helloName(@PathVariable("name") String name) {
		return "hello " + name;
	}
	
	@GetMapping("/calc/{option}/{a}/{b}")
	public float mathCalc(@PathVariable("option") int option, 
			@PathVariable("a") float a,
			@PathVariable("b") float b) {
		float r;
		switch (option) {
		case 1:
			r = a + b;
			break;
		case 2:
			r = a - b;
			break;
		case 3:
			r = a * b;
			break;
		case 4:
			r = a / b;
			break;
		default:
			r = a + b;
			break;
		}
		return r;
	}

}