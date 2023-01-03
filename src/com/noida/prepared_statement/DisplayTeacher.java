package com.noida.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayTeacher {
	static Connection connection;
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_noida_preparedstatement";
			String user="root";
			String pass="mysql";
		 connection=	DriverManager.getConnection(url,user,pass);
		String insert="select * from  teacher";
		
		PreparedStatement preparedstatement=connection.prepareStatement(insert);
	
	ResultSet resultset=preparedstatement.executeQuery();
	     while(resultset.next())
	     {
	    	 System.out.println(resultset.getInt(1));
	    	 System.out.println(resultset.getString(2));
	    	 System.out.println(resultset.getString(3));
	    	 System.out.println("==============");
	     }
		System.out.println("updated");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
