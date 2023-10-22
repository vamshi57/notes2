package in.nareshit.raghu.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.consumer.OrderRestConsumer;
import in.nareshit.raghu.model.Customer;
import in.nareshit.raghu.model.Order;
import in.nareshit.raghu.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;
	@Autowired
	private OrderRestConsumer consumer;
	
	//1. create customer
	@PostMapping("/create")
	public String createCustomer(
			@RequestBody Customer customer
			) 
	{
		Integer id = service.createCustomer(customer);
		return "Customer is created with id :" + id;
	}
	
	//2. place order for a customer
	@PostMapping("/order/{custId}")
	public String placeOrder(
			@PathVariable Integer custId,
			@RequestBody Order order
			) 
	{
		String msg = null;
		//Get Customer
		Optional<Customer> opt = service.getOneCustomer(custId);
		if(opt.isPresent()) {
			//save order
			order = consumer.createOrder(order).getBody();
			//link order
			Customer cust = opt.get();
			cust.setOrder(order);
			//update customer with order
			service.createCustomer(cust);
			msg = " For Customer " + custId +" , order is placed!";
		} else {
			msg = " Customer " + custId +" , Not Found!";
		}
		
		return msg;
	}
	
	//3. get order of a customer
	@GetMapping("/find/{custId}")
	public ResponseEntity<?> getCustomerOrder(
			@PathVariable Integer custId
			) 
	{
		ResponseEntity<?> resp = null;
		if(service.getOneCustomer(custId).isPresent()) {
			Order ord = service.getOrderByCustId(custId);
			resp = ResponseEntity.ok(ord);
		} else {
			resp = new ResponseEntity<String>(
					"No Data Found!",HttpStatus.NOT_FOUND);
		}
		return resp;
	}
	
	//4. get all orders
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return consumer.getAllOrder().getBody();
	}
	
	
}
