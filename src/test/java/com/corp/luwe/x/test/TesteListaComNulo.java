package com.corp.luwe.x.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesteListaComNulo {

	public static void main(String[] args) {
		
		String a = "A", b = "B", c = "C", d = "D";
		List<String> lista = Arrays.asList(a, b, c, d);
		

		System.out.println(constains("B", lista.toArray()));
	}
	
	public static boolean constains(Object value, Object... values) {
		for (Object i : values) {
			if (i.equals(value))
				return true;
		}
		return false;
	}
	
}
