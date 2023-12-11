package com.example.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tarrot2?autoReconnect=true&useSSL=false","root","password");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from javaTests");
			while(rs.next())
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}
