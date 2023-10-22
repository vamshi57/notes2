package in.nareshit.raghu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.model.Customer;
import in.nareshit.raghu.model.Order;
import in.nareshit.raghu.repo.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repo;
	
	public Integer createCustomer(Customer cust) {
		return repo.save(cust).getCustId();
	}
	
	public Optional<Customer> getOneCustomer(Integer id) {
		return repo.findById(id);
	}
	
	public Order getOrderByCustId(Integer custId) {
		return repo.getOrderByCustId(custId);
	}
}
