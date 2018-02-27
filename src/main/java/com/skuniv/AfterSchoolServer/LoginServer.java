//package com.skuniv.AfterSchoolServer;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.junit.runner.Request;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.google.gson.Gson;
//
//@Controller
//public class LoginServer extends RootServer {
//	String id;
//	String pw;
//	private static final Logger logger = LoggerFactory.getLogger(LoginServer.class);
//
//	public LoginServer(int type, String sql) {
//		super(type, sql);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String setAfterResultSet(ResultSet rs) {
//		Teacher teacher = null;
//		String myinfo = "select * from teacher where teacher_id='" + id + "';";
//		try {
//			while (rs.next()) {
//				String t_tc = rs.getString("teacher_code");
//				String t_tn = rs.getString("teacher_name");
//				String t_tpn = rs.getString("teacher_phone_number");
//				String t_te = rs.getString("teacher_email");
//				String t_tbd = rs.getString("teacher_birth_date");
//				String t_ti = rs.getString("teacher_id");
//				String t_tp = rs.getString("teacher_pw");
//				teacher = new Teacher(t_tc, t_tn, t_tpn, t_te, t_tbd, t_ti, t_tp);
//				System.out.println("-_-");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		HashMap<Object, Object> map = new HashMap();
//		//map.put("login", answer);
//		map.put("teacher", teacher);
//
//		Gson gson = new Gson();
//		return gson.toJson(map);
//	}
//
//	@Override
//	public void setAfterUpdate() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public String setQuery(HttpServletRequest request) {
//		id = request.getParameter("id");
//		pw = request.getParameter("pw");
//		String sql = "select teacher_id,teacher_pw from teacher where teacher_id='" + id + "';";
//		return sql;
//	}
//
//	@RequestMapping(value = "/Login", method = RequestMethod.POST, headers = "Content-Type=application/x-www-form-urlencoded")
//	public @ResponseBody String Login(HttpServletRequest request, Model model)
//			throws ClassNotFoundException, SQLException {
//		return sync(request, model);
//
//	}
//
//}
