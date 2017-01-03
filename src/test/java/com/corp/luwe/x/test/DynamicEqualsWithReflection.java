package com.corp.luwe.x.test;

import java.lang.reflect.Field;

public class DynamicEqualsWithReflection {

	public static void main(String[] args) {
		new DynamicEqualsWithReflection();
	}
	
	private DynamicEqualsWithReflection() {
		
		Pessoa ivan1 = new Pessoa("Ivan", null, "M");
		Pessoa ivan2 = new Pessoa("Ivan", 123, "M");
		
		try {
			System.out.println(isEqual(ivan1, ivan2) ? "São iguais" : "Algo diferente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isEqual(Object object, Object another) throws Exception {
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			
			Object objectValue = field.get(object);
			Object anotherValue = field.get(another);
			
			if ((objectValue == null && anotherValue == null) || objectValue == anotherValue) {
				continue;
			}
			
			if (objectValue != null && objectValue.equals(anotherValue)) {
				continue;
			} else if (anotherValue != null && anotherValue.equals(objectValue)) {
				continue;
			}
			
			return false;
		}
		
		return true;
	}
	
}

class Pessoa {
	
	
	private String nome;
	private Integer idade;
	private String sexo;

	public Pessoa(String nome, Integer idade, String sexo) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
