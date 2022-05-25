package domain.one2Many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cart_id;
	private String name;
	private String price;
	
	@OneToMany
	private List<Items> items=new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<Items> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", name=" + name + ", price=" + price + ", items=" + items + "]";
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	



}
