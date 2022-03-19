package hoangdang.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import hoangdang.bookstore.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowProduct {
	private Product product;
	private int totalStar;
}
