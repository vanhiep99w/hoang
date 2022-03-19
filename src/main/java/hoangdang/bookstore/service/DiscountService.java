package hoangdang.bookstore.service;

import java.util.List;

import hoangdang.bookstore.entity.Discount;
import hoangdang.bookstore.entity.User;
import hoangdang.bookstore.model.DiscountModel;

public interface DiscountService {

	DiscountModel createDiscount(DiscountModel discountModel);

	List<Discount> findAll();

	DiscountModel getOneDiscountById(Integer id);

	void delete(Integer id);

	DiscountModel updateDiscount(DiscountModel discountModel);

	Discount getDiscountByCode(String code);

	void updateQuality(Discount discount);

	List<Discount> getListDiscountAvailable();

	User sendCodeDiscount(Integer discountId, User user);

}
