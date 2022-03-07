package amaging.schedu.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import amaging.schedu.db.QMLOracleMapper;

@Service
public class Attendance extends amaging.schedu.common.CommonMethod{
	@Autowired
	QMLOracleMapper om;
  public Attendance() {}
  public void backController(int jobCode, ModelAndView mav) {
	  switch(jobCode) {
	  case 1:
		  this.getArticleForm(mav);
		  break;
	  case 2:
		  this.getASchoolList(mav);
		  break;
	  case 3:
		  this.getCheckForm(mav);
		  break;
	  case 4:
		  this.insertAStatus(mav);
		  break;
	  case 5:
		  this.checkAttendance(mav);
		  break;
	  case 6:
		  this.aStudentList(mav);
		  break;
	  case 7:
		  this.modStudentList(mav);
		  break;
	  case 8:
		  this.saveAttendance(mav);
		  break;
	  case 9:
		  this.matchAcademy(mav);
		  break;	  
	  }
  }
  private void getArticleForm(ModelAndView mav) {}
  private void getASchoolList(ModelAndView mav) {}
  private void getCheckForm(ModelAndView mav) {}
  private void insertAStatus(ModelAndView mav) {}
  private void checkAttendance(ModelAndView mav) {}
  private void aStudentList(ModelAndView mav) {}
  private void modStudentList(ModelAndView mav) {}
  private void saveAttendance(ModelAndView mav) {}
  private void matchAcademy(ModelAndView mav) {}
  
}
