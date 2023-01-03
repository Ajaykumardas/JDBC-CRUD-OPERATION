package com.noida.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTeacher {
	static Connection connection;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_noida_preparedstatement";
			String user="root";
			String pass="mysql";
		 connection=	DriverManager.getConnection(url,user,pass);
		String update="update teacher set name=? where id=?";
		
		PreparedStatement preparedstatement=connection.prepareStatement(update);
		System.out.println("enter a name you want to insert");
		String name=sc.next();
		System.out.println("enter a id");
		int id=sc.nextInt();
		preparedstatement.setString(1, "archi");
		preparedstatement.setInt(2, 102);
		preparedstatement.execute();
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
