package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StoreDataServlet
 */
@WebServlet("/StoreDataServlet")
public class StoreDataServlet extends HttpServlet {
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
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   		PrintWriter out=response.getWriter();
   		String firstname=request.getParameter("firstname");
   		String lastname=request.getParameter("lastname");
   		String email=request.getParameter("email");
   		long phone=Long.parseLong(request.getParameter("phone"));
   		String password=request.getParameter("password");
   		String gender=request.getParameter("gender");
   		String address=request.getParameter("address");
   		String qualification=request.getParameter("qualification");
   		try {
   		Statement st=con.createStatement();
   		String sql=String.format("insert into register values('%s','%s','%s',%d,'%s','%s','%s','%s')",firstname,lastname,email,phone,password,gender,address,qualification);
   		
   		int result=st.executeUpdate(sql);
   		out.println("sucessfully completed and "+result+" row created");
   		}
   		catch(SQLException e) {
   			e.printStackTrace();
   		}
   RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
   rd.forward(request, response);
   	
   	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
   		String firstname=request.getParameter("firstname");
   		String lastname=request.getParameter("lastname");
   		String email=request.getParameter("email");
   		long phone=Long.parseLong(request.getParameter("phone"));
   		String password=request.getParameter("password");
   		String gender=request.getParameter("gender");
   		String address=request.getParameter("address");
   		String qualification=request.getParameter("qualification");
   		try {
   		Statement st=con.createStatement();
   		//String sql=String.format("insert into register values('%s','%s','%s',%d,'%s','%s','%s','%s')",firstname,lastname,email,phone,password,gender,address,qualification);
   		String sql="insert into register values('"+firstname+"','"+lastname+"','"+email+"',"+phone+",'"+password+"','"+gender+"','"+address+"','"+qualification+"')";
   		
   		int result=st.executeUpdate(sql);
   		System.out.println("sucessfully completed and "+result+" row created");
   		}
   		catch(SQLException e) {
   			e.printStackTrace();
   		}
   	
   		response.sendRedirect("login.jsp");
	
	}

}
