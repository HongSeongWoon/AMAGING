package amaging.schedu.privateInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.web.servlet.ModelAndView;

import amaging.schedu.bean.AcList;
import amaging.schedu.bean.RegParent;
import amaging.schedu.bean.UserInfo;
import amaging.schedu.db.TMOracleMapper;

@Service
public class PrivateInfo extends amaging.schedu.common.CommonMethod{
	@Autowired
	TMOracleMapper tm;
	@Autowired
	JavaMailSender javaMail;
	public PrivateInfo() {}
	public void backController(int jobCode, ModelAndView mav) {
		switch(jobCode) {
		case 1:
			this.infoPage(mav);
			break;
		case 2:
			this.checkParentEmail(mav);
			break;
		case 3:
			this.parentRegEmail(mav);
			break;
		case 4:
			this.parentUpdPage(mav);
			break;
		case 5:
			this.updParent(mav);
			break;
		case 6:
			this.searchAc(mav);
			break;	
		case 7:
			this.regAcademy(mav);
			break;	
			
		}
	}
	private void checkParentEmail(ModelAndView mav) {
		mav.addObject("prInfo", tm.checkParentEmail(((RegParent)mav.getModelMap().getAttribute("regp"))));
	}
	private void infoPage(ModelAndView mav) {
		String page=null;
		//int userCode=((UserInfo)mav.getModelMap().getAttribute("uf")).getUserCode();
		/*
		 * if(userCode==1) {
		 *  page="PInfoPage";
		  }else if(userCode==2) {*/
		   page="SInfoPage";
		  //}else{
		 
		//	page="TInfoPage";
//		}
		mav.addObject("category", "regAcademy");
		mav.setViewName(page);
	}
	private void parentRegEmail(ModelAndView mav) {
		
		System.out.println(((RegParent)mav.getModelMap().getAttribute("regp")).getStudentName());
	}
	private void parentUpdPage(ModelAndView mav) {}
	private void updParent(ModelAndView mav) {}
	private void searchAc(ModelAndView mav) {
		mav.addObject("acList", tm.getAcList((AcList)mav.getModelMap().getAttribute("ac"))) ;
	}
	private void regAcademy(ModelAndView mav) {
		String message=null;
		boolean tran=false;
		int result=0;
		this.setTransactionConf(TransactionDefinition.PROPAGATION_REQUIRED,
				TransactionDefinition.ISOLATION_READ_COMMITTED, false);
		if(((UserInfo)mav.getModelMap().getAttribute("uf")).getUserCode()==2) {
			result=tm.regSAcademy((UserInfo)mav.getModelMap().getAttribute("uf"));
		}else {
			result=tm.regTAcademy((UserInfo)mav.getModelMap().getAttribute("uf"));
		}
		if(this.convertToBoolean(result)) {
			tran=true;
			message="학원 등록 요청에 성공하였습니다. 수락은 학원 측에 문의하세요.";
		}else if(result==0){
			message="이미 등록 요청기록이 존재합니다. 학원 측에 문의하세요.";
		}else {message="학원 등록 요청에 실패하였습니다. 다시 시도해주세요.";}
		this.setTransactionEnd(tran);
		mav.addObject("message",message);
	}
}