package amaging.schedu.db;


import amaging.schedu.bean.ChildCode;
import amaging.schedu.bean.Login;
import amaging.schedu.bean.RegMember;

public interface QMLOracleMapper {
	public int isUser(Login login);
	public int isStudentEmail(Login login);
	public int isParentsEmail(Login login);
	public int isTeacherEmail(Login login);
	public int isAdminCode(Login login);
	public int isStudentPassword(Login login);
	public int isParentsPassword(Login login);
	public int isTeacherPassword(Login login);
	public int isAdminPassword(Login login);
	public int setAccessHistory(Login login);
	public int setStudentData(RegMember regM);
	public int setParentsData(RegMember regM);
	public int displayChildList(ChildCode child);
	
}
