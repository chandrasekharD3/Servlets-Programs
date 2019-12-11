package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class allServletrequestMethods
 */
@WebServlet("/allServletrequestMethods")
public class allServletrequestMethods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allServletrequestMethods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out=response.getWriter();
	
	//it is for first name and firstrequestmethod use
	System.out.println("type1");
	
	String s=(String)request.getParameter("firstname");
	
	//for console
	System.out.println(s);
	//for website
	out.println(s);
	//it is for second type of requestmethod use
	System.out.println("type2");
	String tem[]=request.getParameterValues("skills");
	for(int i=0;i<tem.length;i++) {
		//for console
		System.out.println("skills is "+ tem[i]);
		//for website
		out.println("skills is "+ tem[i]);
	}
	//it is for type three requestmethod use
	System.out.println("type3");
	String third=request.getQueryString();
	String split[]=third.split("&");
	for(int i=0;i<split.length;i++) {
		String name=split[i].substring(0,split[i].indexOf("="));
		String value=split[i].substring(split[i].indexOf("=")+1);
		
		//for console
		System.out.println("name is "+name+" value is "+value );
		//for website
		out.println("name is "+name+" value is "+value );
	}
	//it is for type forth requestmethod use
	System.out.println("type4");
	Map map=request.getParameterMap();
	Set set=map.keySet();
	Iterator iterate=set.iterator();
	while(iterate.hasNext()) {
		String name=(String)iterate.next();
		String values[]=(String[])map.get(name);
			//for website
			out.println(" name "+name+" value is "+ Arrays.toString(values));
			//for console
			System.out.println(" name "+name+" value is "+ Arrays.toString(values));
	}
	//it is for fifth requestmethod use
	System.out.println("type5");
	Enumeration enume=request.getParameterNames();
	while(enume.hasMoreElements()) {
		String name3=(String)enume.nextElement();
		String value3=		request.getParameter(name3);
		//for website
		out.println("name is "+ name3 +" value3 is "+ value3);
		//for console
		System.out.println("name is "+ name3 +" value3 is "+ value3);
	}
	
	
	
	}

}
