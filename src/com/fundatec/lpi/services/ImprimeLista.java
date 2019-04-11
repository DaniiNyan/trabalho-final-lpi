package com.fundatec.lpi.services;

import java.util.List;

import com.fundatec.lpi.domain.Item;

public class ImprimeLista {
	
	public void imprime (List<Item> itens) {
		for (Item item : itens) {
			System.out.format("%s - %s - %s", item.getId(), item.getNome(), item.getPreco());
		}
		
	}

}
