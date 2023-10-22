package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.consumer.BranchRestConsumer;

@RestController
@RequestMapping("/company")
public class CompanyRestController {
	
	@Autowired
	private BranchRestConsumer consumer;

	@GetMapping("/data")
	public String showInfo() {
		return "Company Msg!" + consumer.getBranchData();
	}
	
}

