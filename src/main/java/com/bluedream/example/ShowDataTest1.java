package com.bluedream.example;

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
 * Servlet implementation class ShowDataTest1
 */
@WebServlet("/ShowDataTest1")
public class ShowDataTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDataTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>ShowDateTest1 Servlet from Bluedream application on OpenShift</h1>");
		connectionDB(out);
		
		out.println("Served at: " + request.getContextPath());
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void connectionDB(PrintWriter pOut) {
	   // JDBC driver name and database URL
	   String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   // static final String DB_URL = "jdbc:mysql://admin:adminTs7AvzM@127.2.45.130:3306/classicmodels";
	   // For OpenShift
	      String DB_URL = "jdbc:mysql://172.30.218.182:3306/classicdb1";
	   // For Localhost
	      // String DB_URL = "jdbc:mysql://localhost:3366/classicmodels";
		   
	   //  Database credentials
	   // For OpenShift 
	      String USER = "adminTs7AvzM";
	      String PASS = "DBDLSpx-a5wW";
	   // For Localhost
	      //String USER = "CM_AP1";
	      //String PASS = "CmAp1@123";

		   
       Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      pOut.println("Connecting to database... </br>");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      pOut.println("Creating statement...</br>");
		  stmt = conn.createStatement();
		  String sql;
		  sql = "SELECT * FROM customers LIMIT 0 , 30";
		  ResultSet rs = stmt.executeQuery(sql);

		  //STEP 5: Extract data from result set
		  while(rs.next()){
		       //Retrieve by column name
		       int intCustomerNumber  = rs.getInt("customerNumber");
		       // int age = rs.getInt("age");
		       String strCustomerName = rs.getString("customerName");
		       String strPhone = rs.getString("phone");
		       String strContactLastName = rs.getString("contactLastName");

		       //Display values
		       pOut.print("intCustomerNumber: " + intCustomerNumber + " ");		         
		       pOut.print("strCustomerName: " + strCustomerName + " ");
		       pOut.println("strContactLastName: " + strContactLastName + " ");
		       pOut.println("strPhone: " + strPhone + "</br>");
		       
		   }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	       pOut.println("Fetch data is finished!");
	}
	

}
