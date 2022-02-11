

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanlogin.Bean1;

/**
 * Servlet implementation class beanSer
 */
@WebServlet("/beanSer")
public class beanSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public beanSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		PrintWriter out = response.getWriter();
		try
		{
			Bean obj = new Bean();
			obj.setStaffid(request.getParameter("txtsid"));
			obj.setPassword(request.getParameter("txtpass"));
			obj.setFullname(request.getParameter("txtfname"));
			obj.setRole(request.getParameter("txtrole"));
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/staff","root","");
			Statement st = conn.createStatement();
			int res = st.executeUpdate("insert into staffinfo(staffid,password,fullname,role) values('"+obj.getStaffid()+"','"+obj.getPassword()+"','"+obj.getFullname()+"','"+obj.getRole()+"')");
			if(res!=0)
			{
				out.print("Data Submitted Successfully");
			}
		}
		
		catch(Exception ex)
		{
			out.print(ex.getMessage());
		}
	}

}
