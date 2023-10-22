package in.nareshit.raghu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ordtab")
public class Order {
	@Id
	@GeneratedValue
	private Integer orderId;
	private String orderCode;
	private Double orderCost;
	
}
