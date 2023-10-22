package in.nareshit.raghu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Integer custId;
	private String custName;
	private String custAddr;
	
	@ManyToOne //1...1
	@JoinColumn(name="ord_id_fk_col",unique = true)
	private Order order; //HAS-A
}
