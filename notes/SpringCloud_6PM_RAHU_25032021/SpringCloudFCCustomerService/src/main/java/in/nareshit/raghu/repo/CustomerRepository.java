package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nareshit.raghu.model.Customer;
import in.nareshit.raghu.model.Order;

public interface CustomerRepository 
	extends JpaRepository<Customer, Integer>
{

	@Query("SELECT order FROM Customer cust INNER JOIN cust.order as order WHERE cust.id=:custId")
	Order getOrderByCustId(Integer custId);

}
