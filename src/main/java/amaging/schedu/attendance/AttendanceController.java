package amaging.schedu.attendance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import amaging.schedu.bean.AcList;

@Controller
public class AttendanceController {
	private Attendance ad;
	@PostMapping("/GetASchoolList")
	public ModelAndView getASchoollIst(ModelAndView mav, @ModelAttribute AcList al) {
		return mav;
	}
}
