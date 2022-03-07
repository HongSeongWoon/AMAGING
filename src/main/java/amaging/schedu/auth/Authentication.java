package amaging.schedu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import amaging.schedu.db.QMLOracleMapper;
@Service
public class Authentication extends amaging.schedu.common.CommonMethod{
	@Autowired
	QMLOracleMapper om;
	public Authentication() {
		
	}

	public void backController(int jobCode, ModelAndView mav) {
		switch(jobCode) {
		case 1:
			this.moveLoginPage(mav);
			break;
		case 2:
			this.login(mav);
			break;
		case 3:
			this.logout(mav);
			break;
		case 4:
			this.join(mav);
			break;
		case 5:
			this.getChildList(mav);
			break;
		}
	}
	private void moveLoginPage(ModelAndView mav) {

	}
	private void login(ModelAndView mav) {

	}
	private void logout(ModelAndView mav) {
		
	}
	private void join(ModelAndView mav) {}
	private void getChildList(ModelAndView mav) {}
	
}
