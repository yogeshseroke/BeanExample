

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanlogin.Bean1;

import java.sql.*;


/**
 * Servlet implementation class beanloginSer
 */
@WebServlet("/beanloginSer")
public class beanloginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public beanloginSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.sendRedirect("beanlogin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		try {
			Bean1 obj=new Bean1();
			obj.setUserid(request.getParameter("uid"));
			obj.setPassword(request.getParameter("pass"));
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/beanExample","root","");
			Statement st=con.createStatement();
			int x=st.executeUpdate("insert into login(username,password) values('"+obj.getUserid()+"','"+obj.getPassword()+"')");
            if(x!=0)
            {
            	out.println("data inserted successfully");
            }
		}
		catch(Exception ex) {
			out.println(ex.getMessage().toString());
		}
		
	}

}
