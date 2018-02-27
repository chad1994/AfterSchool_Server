package com.skuniv.AfterSchoolServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
public abstract class RootServer {
	public Connection conn = null;
	private int type;
	public static final int INSERT_UPDATE_DELETE = 0;
	public static final int SELECT = 1;
	String sql;
	private String result = "";
	
	public RootServer(int type, String sql) {
		this.type = type;
		this.sql = sql;
	}
	public abstract String setQuery(HttpServletRequest request);
	public abstract String setAfterResultSet(ResultSet rs);
	public abstract void setAfterUpdate();
	
	public String sync(HttpServletRequest request, Model model) throws SQLException, ClassNotFoundException {
		String answer = "empty";
		
			String url = "jdbc:mysql://192.168.0.6:3306/afterschool"; // 사용하려는 데이터베이스명을 포함한 URL
			String db_id = "afterschool"; // 사용자 계정
			String db_pw = "qwerty1234!"; // 사용자 계정의 패스워드
		
			// 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, db_id, db_pw); // DriverManager 객체로부터 Connection 객체를 얻어온다.
			System.out.println("success connect");


		////
		java.sql.Statement stmt = conn.createStatement();
		sql = setQuery(request);
		if(type==INSERT_UPDATE_DELETE) {
			stmt.executeUpdate(sql);
			setAfterUpdate();
		}else if(type==SELECT){
			result = setAfterResultSet(stmt.executeQuery(sql));
		}
		
		stmt.close();
		conn.close();

		return result;
	}
}
