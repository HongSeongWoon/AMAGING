package amaging.schedu.auth;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import amaging.schedu.bean.Login;
import amaging.schedu.bean.RegMember;
import amaging.schedu.bean.UserInfo;

@Controller
public class AuthController {

	private Authentication auth;
	@PostMapping("/Login")
	public ModelAndView login(ModelAndView mav, @ModelAttribute Login lg) {
				
		return mav;
	}
	@PostMapping("/Logout")
	public ModelAndView logout(ModelAndView mav, @ModelAttribute Login lg) {
				
		return mav;
	}
	@PostMapping("/Join")
	public ModelAndView join(ModelAndView mav, @ModelAttribute RegMember rm) {
				
		return mav;
	}
	@PostMapping("/GetChildList")
	public ModelAndView getChildList(ModelAndView mav, @ModelAttribute UserInfo uf) {
				
		return mav;
	}
}
