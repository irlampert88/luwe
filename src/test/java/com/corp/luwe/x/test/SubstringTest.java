package com.corp.luwe.x.test;

public class SubstringTest {

	public static void main(String[] args) {

		System.out.println("AB=" + limitarTamanhoDoCampo("ABC", 2));
		System.out.println("A=" + limitarTamanhoDoCampo("A", 2));
		System.out.println("A=" + limitarTamanhoDoCampo("ABCDEF", 1));
		System.out.println("ABC=" + limitarTamanhoDoCampo("ABC", 10));
		System.out.println("=" + limitarTamanhoDoCampo("", 5));
		
	}
	
	private static String limitarTamanhoDoCampo(String valorDoCampo, int tamanhoLimite) {
		if (valorDoCampo != null && !valorDoCampo.trim().isEmpty()) {
			if (valorDoCampo.length() >= tamanhoLimite) {
				return valorDoCampo.substring(0, tamanhoLimite);
			}
		}
		
		return valorDoCampo;
	}
	
}
