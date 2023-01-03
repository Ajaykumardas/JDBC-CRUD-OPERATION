package com.noida.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Teacher {
  static Connection connection=null;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			//step 1 load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_noida_preparedstatement";
			String user="root";
			String pass="mysql";
			//step2 create the connection
			 connection=DriverManager.getConnection(url, user, pass);
			 //by using placeholder
			 
			String insert="insert into teacher values(?,?,?)";
			//step 3 create the statement
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			System.out.println("enter id no");
			int id=sc.nextInt();
			System.out.println("enter name  ");
			String name=sc.next();
			System.out.println("eneter the email");
			String email=sc.next();
			
			preparedstatement.setInt(1, id);
			preparedstatement.setString(2, name);
			preparedstatement.setString(3, email);
			
			//execute query
			preparedstatement.execute();
			System.out.println("data inserted");
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
