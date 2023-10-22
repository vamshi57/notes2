package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@Scope("prototype")
public class EmpRestController {
	@Autowired
	private RestTemplate rt;

	@GetMapping("/data")
	public String showData() {
		return "WELCOME TO APP!";
	}
}
