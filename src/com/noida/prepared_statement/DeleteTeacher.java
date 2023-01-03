package com.noida.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTeacher {
	static Connection connection=null;
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_noida_preparedstatement";
			String user="root";
			String pass="mysql";
		 connection=	DriverManager.getConnection(url,user,pass);
		String delete="delete from teacher where id=?";
		
		PreparedStatement preparedstatement=connection.prepareStatement(delete);
		preparedstatement.setInt(1, 102);
		preparedstatement.execute();
		System.out.println("deleted");
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
