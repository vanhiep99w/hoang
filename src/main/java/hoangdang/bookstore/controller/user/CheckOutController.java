package hoangdang.bookstore.controller.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hoangdang.bookstore.service.DiscountService;
import hoangdang.bookstore.service.OrderService;
import hoangdang.bookstore.service.ParamService;
import hoangdang.bookstore.service.impl.MailerServiceImpl;
import hoangdang.bookstore.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hoangdang.bookstore.common.Constants;
import hoangdang.bookstore.entity.Address;
import hoangdang.bookstore.entity.Discount;
import hoangdang.bookstore.entity.Order;
import hoangdang.bookstore.entity.Product;
import hoangdang.bookstore.model.CartModel;
import hoangdang.bookstore.service.AddressService;
import hoangdang.bookstore.service.ProductService;
import hoangdang.bookstore.service.SessionService;

@Controller
public class CheckOutController {
	@Autowired
	AddressService addressService;

	@Autowired
	AddressService provinceService;
	
	@Autowired
    ShoppingCartServiceImpl cartService;
	
	@Autowired
    DiscountService discountService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
    ParamService paramService;
	
	@Autowired
    OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
    MailerServiceImpl mailerService;

	@GetMapping("/shop/cart/checkout")
	public String index(Model model) {
		List<CartModel> listCartModel = new ArrayList<>(cartService.getItems());
		if(listCartModel.isEmpty()) {
			return "redirect:/shop/cart";
		}
		model.addAttribute("cart", cartService);
		return Constants.USER_DISPLAY_CHECKOUT;
	}
	
	@PostMapping("/shop/cart/checkout")
	public String order(Model model) {
		String addressId = paramService.getString("address_id", "");
		String method = paramService.getString("shipping_method", "");
		String comment = paramService.getString("comment", null);
		
		Address address = addressService.getAddressById(Integer.parseInt(addressId));
		
		Discount discount = cartService.getDiscount();
		
		if(discount.getId() == 0) {
			discount = null;
		}	
		
		int code;
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatter.format(date);
		
		while (true) {
			code = (int) Math.floor(((Math.random() * 899999) + 100000));
			List<Order> list = orderService.getOrderByName(String.valueOf(code));
			if (list.isEmpty()) {
				break;
			}
		}
		
		List<CartModel> listCartModel = new ArrayList<>(cartService.getItems());
		for(CartModel cart: listCartModel) {
			Order order = new Order();
			Product product = cart.getProduct();
			order.setCode(String.valueOf(code));			
			order.setAddress(address);
			order.setDiscount(discount);
			order.setProduct(product);
			order.setQuality(cart.getQuality());
			order.setDate(strDate);
			order.setMethod(method);
			order.setStatus("0");
			order.setComment(comment);
			orderService.save(order);
			
			product.setQuality(product.getQuality() - cart.getQuality());
			productService.updateQuality(product);
		}
		
		discountService.updateQuality(discount);
		
		cartService.clear();
		cartService.clearDiscount();
		model.addAttribute("cart", cartService);
		
		mailerService.queue(address.getUser().getEmail(), "Đặt Hàng Thành Công Tại Web FAHASA", 
				"Kính chào " + address.getUser().getFullname() +",<br>"
				+ "Cảm ơn bạn đã mua hàng tại FAHASA. Mã đơn hàng của bạn là " + code + "<br>"
				+ "Xin vui lòng click vào đường link http://localhost:8080/account/order/invoice/" + code + " để xem chi tiết hóa đơn.<br>"
				+ "<br><br>"
				+ "Xin chân thành cảm ơn đã sử dụng dịch vụ,<br>"
				+ "FASAHA SHOP");
		
		
		return "redirect:/shop/cart/checkout/success";
	}
	
	@GetMapping("/shop/cart/checkout/success")
	public String success(Model model) {
		return Constants.USER_DISPLAY_CHECKOUT_SUCCESS;
	}
	
	@ModelAttribute("total")
	public int tolal() {
		List<CartModel> list = new ArrayList<>(cartService.getItems());
		int total = 0;
		for(CartModel i: list) {
			total = total + i.getProduct().getPrice() * i.getQuality();
		}
		return total;
	}

	@ModelAttribute("listAddress")
	public List<Address> getListAddress(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		return addressService.findListAddressByEmail(username);
	}
}
