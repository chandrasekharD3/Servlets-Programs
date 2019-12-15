package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	Connection con;
	public void init() throws ServletException {
		
System.out.println("int it");	
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
}
catch(ClassNotFoundException e) {
	e.printStackTrace();
}
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","chandra");
		
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Statement st;
		ResultSet rs;
		try {
    		 st=con.createStatement();
		
    		 String firstname=request.getParameter("username");
    			String password=request.getParameter("password");
    		
    			String sql="select firstname,password from register where firstname='"+firstname+"' and password='"+password+"'";
    			
    			rs=st.executeQuery(sql);
    			
    			int i=0;
    			while(rs.next()) {
    				i++;
    			}
    			if(i>0) {
    				out.println("sucessfully log in");
    			}
    			else {
    				out.println("wrong username password");
    				
    			}
    		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
		
	
}
}