package hoangdang.bookstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hoangdang.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import hoangdang.bookstore.service.InformationShopService;
import hoangdang.bookstore.service.SessionService;
import hoangdang.bookstore.service.ShoppingCartService;


@Component
public class GlobalInterceptor implements HandlerInterceptor {
	@Autowired
    CategoryService categoryService;
	
	@Autowired
	InformationShopService informationService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	ShoppingCartService cartService;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("categories", categoryService.findAll());
		request.setAttribute("information", informationService.getOneInformationShop());
		sessionService.set("sessionProduct", cartService);
	}
}
