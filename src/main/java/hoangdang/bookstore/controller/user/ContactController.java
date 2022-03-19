package hoangdang.bookstore.controller.user;

import hoangdang.bookstore.service.ContactService;
import hoangdang.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hoangdang.bookstore.common.Constants;

@Controller
public class ContactController {
	@Autowired
    ContactService contactService;
	@Autowired
    UserService userService;
	@GetMapping("/contact")
	public String index(Model model) {
		return Constants.USER_DISPLAY_CONTACT;
	}
}
