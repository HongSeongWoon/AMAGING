package amaging.schedu.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import amaging.schedu.attendance.Attendance;
import amaging.schedu.bean.UserInfo;
import amaging.schedu.calender.Calender;
import amaging.schedu.fee.Fee;
import amaging.schedu.grade.Grade;
import amaging.schedu.personnel.Personnel;
import amaging.schedu.privateInfo.PrivateInfo;
import amaging.schedu.qna.QnA;
import amaging.schedu.timeTable.TimeTable;


@Controller
public class MovePageController {
	@Autowired
	private Calender cal;
	@Autowired
	private QnA qna;
	@Autowired
	private TimeTable tt;
	@Autowired
	private Fee fee;
	@Autowired
	private Grade grade;
	@Autowired
	private Attendance ad;
	@Autowired
	private Personnel ps;
	@Autowired
	private PrivateInfo pi;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String accessPSMain() {
		
		return "SPMain";
	}
	@RequestMapping(value = "/TAonly", method = RequestMethod.GET)
	public String accessTAMain() {
		
		return "TAMain";
	}
	
	@RequestMapping(value = "/LoginPage", method = RequestMethod.GET)
	public String moveLoginPage() {
		String page=null;
		return page;
	}
	@GetMapping("/JoinPage")
	public String studentJoinpage() {
		return "join";
	}
	@PostMapping("/AcPlanPage")
	public ModelAndView acPlanPage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		cal.backController(1, mav);
		return mav;
	}
	@PostMapping("/PSClassPage")
	public ModelAndView psClassPage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		tt.backController(0, mav);
		return mav;
	}
	@PostMapping("/TClassPage")
	public ModelAndView tClassPage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		tt.backController(0, mav);
		return mav;
	}
	@PostMapping("/AClassPage")
	public ModelAndView aClassPage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		tt.backController(0, mav);
		return mav;
	}
	@PostMapping("/AFeePage")
	public ModelAndView aFeePage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		fee.backController(0, mav);
		return mav;
	}
	@PostMapping("/TFeePage")
	public ModelAndView tFeePage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		fee.backController(0, mav);
		return mav;
	}
	@PostMapping("/TGradePage")
	public ModelAndView tGradePage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		grade.backController(0, mav);
		return mav;
	}
	@PostMapping("/GradePage")
	public ModelAndView gradePage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		grade.backController(0, mav);
		return mav;
	}
	@PostMapping("/GetArticleForm")
	public ModelAndView getArticleForm(ModelAndView mav, @ModelAttribute UserInfo uf) {
		ad.backController(0, mav);
		return mav;
	}
	@PostMapping("/MoveAdminPage")
	public ModelAndView moveAdminPage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		ps.backController(0, mav);
		return mav;
	}
	@PostMapping("/InfoPage")
	public ModelAndView infoPage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		pi.backController(0, mav);
		return mav;
	}
	@PostMapping("/SQnAPage")
	public ModelAndView sQnAPage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		qna.backController(0, mav);
		return mav;
	}
	@PostMapping("/PQnAPage")
	public ModelAndView pQnAPage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		qna.backController(0, mav);
		return mav;
	}
	@PostMapping("/TQnAPage")
	public ModelAndView tQnAPage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		qna.backController(0, mav);
		return mav;
	}
	@PostMapping("/AQnAPage")
	public ModelAndView aQnAPage(ModelAndView mav, @ModelAttribute UserInfo uf) {
		qna.backController(0, mav);
		return mav;
	}
}
