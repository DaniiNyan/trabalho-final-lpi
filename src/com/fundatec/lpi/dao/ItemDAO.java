package com.fundatec.lpi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fundatec.lpi.domain.Item;

public class ItemDAO implements BaseDAO<Item>{
	
	@Override
	public void save(Item item) {
		try {
			String mysqlDriver = "com.mysql.cj.jdbc.Driver"; 
			Class.forName(mysqlDriver);

			String connectionString = "jdbc:mysql://localhost/trabalho-final?user=root&password=";
			Connection connect = DriverManager.getConnection(connectionString);

			Statement statement = connect.createStatement();
			String query = "INSERT INTO ITENS (NOME, PRECO) VALUES (?, ?)";
			
			PreparedStatement preparedStmt = connect.prepareStatement(query);
		    preparedStmt.setString (1, item.getNome());
		    preparedStmt.setFloat(2, item.getPreco());
		    preparedStmt.execute();			    
		    
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Item> listAll() {
		List<Item> resultado = new ArrayList<Item>();
		
		try {
			String mysqlDriver = "com.mysql.cj.jdbc.Driver"; 
			Class.forName(mysqlDriver);

			String connectionString = "jdbc:mysql://localhost/trabalho-final?user=root&password=";
			Connection connect = DriverManager.getConnection(connectionString);
			
			Statement statement = connect.createStatement();
			String query = "SELECT * FROM ITENS";
			
			ResultSet resultSet = statement.executeQuery(query);			
			
			for (Item result : resultado) {
				resultado.add(result);				
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Item objeto) {
		// TODO Auto-generated method stub
		
	}

}
