package in.nareshit.raghu.consumer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.nareshit.raghu.model.Order;

@FeignClient("ORDER-SERVICE")
public interface OrderRestConsumer {

	@PostMapping("/order/create")
	public ResponseEntity<Order> createOrder(
			@RequestBody Order order);
	
	@GetMapping("/order/one/{id}")
	public ResponseEntity<Order> getOneOrder(
			@PathVariable Integer id) ;
	
	@GetMapping("/order/all")
	public ResponseEntity<List<Order>> getAllOrder();
}
