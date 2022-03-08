package amaging.schedu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import amaging.schedu.bean.Login;
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
		Login lg = new Login();
		lg = (Login) mav.getModel().get("login");
		System.out.println(lg.getUserCode());
		String page = "";// 1¹ø page

		try {

			if (lg.getUserCode() == 3) {
				mav.addObject("accessInfo", om.isTeacherEmail(lg));
				page = "Tmainservices";
			}else if(lg.getUserCode() == 1){
				mav.addObject("accessInfo", om.isParentsEmail(lg));
				page = "Pmainservices";
			}else if(lg.getUserCode() == 2){
				mav.addObject("accessInfo", om.isStudentEmail(lg));
				page = "Smainservices";
			}else {
				mav.addObject("accessInfo", om.isAdminCode(lg));
				page = "Amainservices";
			}

			pu.setAttribute("sessionInfo", mav.getModel().get("accessInfo"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.setViewName(page);
	   }
	
	private void logout(ModelAndView mav) {
		
	}
	private void join(ModelAndView mav) {}
	private void getChildList(ModelAndView mav) {}
	
}
