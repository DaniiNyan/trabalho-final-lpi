package com.fundatec.lpi.main;

import java.util.Scanner;

import com.fundatec.lpi.dao.ItemDAO;
import com.fundatec.lpi.domain.Item;
import com.fundatec.lpi.services.ImprimeLista;

public class App {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int comando = 0;

		do {
			System.out.println("Sistema de Estoque - Escolha uma opção:");
			System.out.println("---------------------------------------");
			System.out.println("1 - Cadastro de item");
			System.out.println("2 - Listar itens");
			System.out.println("3 - Editar item por ID");
			System.out.println("4 - Excluir item por ID");
			System.out.println("5 - Mostrar custo total do estoque");
			System.out.println("0 - Sair");
			System.out.println("");
			System.out.println("Qual opção?");
			comando = teclado.nextInt();

			switch (comando) {
				case 1: {
					System.out.println("Você escolheu cadastrar item.");
					System.out.println("=> NOME: ");
					String nome = teclado.next();
	
					System.out.println("=> PREÇO: ");
					float preco = teclado.nextFloat();
	
					Item item = new Item(nome, preco);
					ItemDAO itemDAO = new ItemDAO();
					itemDAO.save(item);
					
					System.out.println("Salvo com sucesso!");
					System.out.println("---------------------------------------");
					break;
				}
				
				case 2: {
					System.out.println("Você escolheu listar itens.");
					
					ItemDAO itemDAO = new ItemDAO();
					ImprimeLista imprimir = new ImprimeLista();
					imprimir.imprime(itemDAO.listAll());
					
					System.out.println("---------------------------------------");
					break;
				}
				
				case 3: {
					System.out.println("Você escolheu editar item.");
					System.out.println("=> ID: ");
					int idOriginal = teclado.nextInt();
					
					System.out.println("=> NOME: ");
					String novoNome = teclado.next();
	
					System.out.println("=> PREÇO: ");
					float novoPreco = teclado.nextFloat();
	
					Item item = new Item(idOriginal, novoNome, novoPreco);
					ItemDAO itemDAO = new ItemDAO();
					itemDAO.update(item);
					
					System.out.println("---------------------------------------");
					break;
					
				}
				
				case 4: {
					System.out.println("Você escolheu excluir item.");
					System.out.println("=> ID: ");
					int id = teclado.nextInt();
					
					ItemDAO itemDAO = new ItemDAO();
					itemDAO.delete(id);
					
					System.out.println("---------------------------------------");
					
					break;
				}
				
				case 5: {
					System.out.println("Custo total do estoque:");
					System.out.println("---------------------------------------");
					break;
				}
				
				case 0: {
					System.out.println("---------------------------------------");
					System.out.println("Você saiu.");
					
					break;
				}
				
				default: {
					System.out.println("Você não digitou um comando válido.");
					System.out.println("---------------------------------------");
					break;
				}
					
			}

		} while (comando != 0);

		teclado.close();
	}
}
