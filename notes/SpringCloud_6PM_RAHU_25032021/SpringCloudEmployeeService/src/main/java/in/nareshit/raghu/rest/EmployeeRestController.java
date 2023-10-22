package in.nareshit.raghu.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {

	@GetMapping("/msg")
	public String showMsg() {
		return "Welcome to First MSApp!";
	}
}
