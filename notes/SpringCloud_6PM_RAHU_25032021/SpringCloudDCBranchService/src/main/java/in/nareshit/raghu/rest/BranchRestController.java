package in.nareshit.raghu.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch")
public class BranchRestController {

	@GetMapping("/msg")
	public String showBranchMsg() {
		return "FROM BRANCH SERVICE";
	}
}
