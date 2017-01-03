package com.corp.luwe.x.test;

import java.util.Arrays;
import java.util.List;

public class ExpressionTest {

	public static void main(String[] args) {

		List<String> categorias = Arrays.asList("A", "A1", "1A1", "A A", "A1A", "A 1", "A 1 A", "A A A", "A 1 2 3 A", "1 2 3", "1");
		List<String> categoriasCertas = Arrays.asList("A", "A", "A", "AA", "AA", "A", "AA", "AAA", "AA", "", "");
		
		for (int i = 0; i < categorias.size(); i++) {
			if (!formataCategoria(categorias.get(i)).equals(categoriasCertas.get(i))) {
				System.out.println("NÃO ESTÁ CERTO: " + categorias.get(i) + " - " + categoriasCertas.get(i));
			}
		}
		
		System.out.println("TUDO CERTINHO!");
	}

	private static String formataCategoria(String string) {
		
		return string.trim().replaceAll("[^A-Z]", "").trim(); 
	}
	
}
