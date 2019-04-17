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
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				float preco = resultSet.getFloat("preco");
				
				System.out.format("%s - %s - %s\n", id, nome, preco);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public void delete(int id) {
		try {
			String mysqlDriver = "com.mysql.cj.jdbc.Driver"; 
			Class.forName(mysqlDriver);

			String connectionString = "jdbc:mysql://localhost/trabalho-final?user=root&password=";
			Connection connect = DriverManager.getConnection(connectionString);
			
			Statement statement = connect.createStatement();
			String query = "DELETE FROM ITENS WHERE ID = " + id + ";";
			
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			preparedStmt.execute();
			
			int linhasAfetadas = preparedStmt.getUpdateCount();
		    if (linhasAfetadas < 1) {
		    	System.out.println("Id inválido.");
		    } else {
		    	System.out.println("Deletado com sucesso!");
		    }   
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Item item) {
		try {
			String mysqlDriver = "com.mysql.cj.jdbc.Driver"; 
			Class.forName(mysqlDriver);

			String connectionString = "jdbc:mysql://localhost/trabalho-final?user=root&password=";
			Connection connect = DriverManager.getConnection(connectionString);
			
			Statement statement = connect.createStatement();
			String query = "UPDATE ITENS SET NOME = ?, PRECO = ? WHERE ID = " + item.getId() + ";";
			
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			preparedStmt.setString (1, item.getNome());
		    preparedStmt.setFloat(2, item.getPreco());			
		    preparedStmt.execute();
		    
		    int linhasAfetadas = preparedStmt.getUpdateCount();
		    if (linhasAfetadas < 1) {
		    	System.out.println("Id inválido.");
		    } else {
		    	System.out.println("Editado com sucesso!");
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
