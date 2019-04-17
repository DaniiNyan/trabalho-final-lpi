package com.fundatec.lpi.domain;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private List<Item> estoque = new ArrayList<Item>();

	public Estoque(List<Item> estoque) {
		this.estoque = estoque;
	}

	public List<Item> getEstoque() {
		return estoque;
	}

	public void setEstoque(List<Item> estoque) {
		this.estoque = estoque;
	}

	public float custoTotal(List<Item> itens) {
		// calcula custo total
		float valorTotal = 0;
		
		

		return valorTotal;
	}

}
