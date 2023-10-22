package in.nareshit.raghu.consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BranchRestConsumer {

	//#1. Autowire Discovery Client
	@Autowired
	private DiscoveryClient client;
	
	public String getBranchData() {
		//#2. call method getInstances(SID)
		//#3 Read List<SI>
		List<ServiceInstance> list = client.getInstances("BRANCH-SERVICE");
		
		//#4. Read SI from index#0
		ServiceInstance si = list.get(0);
		
		//#5. Read URI from SI
		URI uri = si.getUri();
		
		//#6. Add path to URI that given URL
		String url = uri + "/branch/msg";
		
		//#7. make Request call using RestTemplate
		RestTemplate rt = new RestTemplate();
		String response = rt.getForObject(url, String.class);
		
		//#8 return response to (ConsumerApp)RestController
		return response;
	}
 	
}
