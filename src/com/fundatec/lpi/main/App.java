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
			/*
			 * Sistema de Estoque - Escolha uma op��o:
			 * --------------------------------------- 1 - Cadastro de item 2 - Listar items
			 * 3 - Editar item por ID 4 - Excluir item por ID 5 - Mostrar custo total do
			 * estoque 0 - Sair Qual op��o?
			 */

			System.out.println("Sistema de Estoque - Escolha uma op��o:");
			System.out.println("---------------------------------------");
			System.out.println("1 - Cadastro de item");
			System.out.println("2 - Listar itens");
			System.out.println("3 - Editar item por ID");
			System.out.println("4 - Excluir item por ID");
			System.out.println("5 - Mostrar custo total do estoque");
			System.out.println("0 - Sair");
			System.out.println("");
			System.out.println("Qual op��o?");
			comando = teclado.nextInt();

			switch (comando) {
				case 1: {
					System.out.println("Voc� escolheu cadastrar item.");
					System.out.println("=> NOME: ");
					String nome = teclado.next();
	
					System.out.println("=> PRE�O: ");
					float preco = teclado.nextFloat();
	
					Item item = new Item(nome, preco);
					ItemDAO itemDAO = new ItemDAO();
					itemDAO.save(item);
					break;
				}
				
				case 2: {
					System.out.println("Voc� escolheu listar itens.");
					
					Item item = new Item();
					ItemDAO itemDAO = new ItemDAO();
					ImprimeLista imprimir = new ImprimeLista();
					imprimir.imprime(itemDAO.listAll());					
					break;
				}
					
			}

		} while (comando != 0);

		teclado.close();
		System.out.println("Voc� saiu.");
	}
}
