package com.corp.luwe.x.test;

public class MemoryObjectReferenceChange {

	public static void main(String[] args) {
		new MemoryObjectReferenceChange();
	}
	
	public MemoryObjectReferenceChange() {
		Pessoa p = criaPessoa();
		
		String cpf = p.getId().getCpf();
		
		System.out.println(cpf);

		p.getId().setCpf("2222222");
		
		System.out.println(cpf);
	}

	private Pessoa criaPessoa() {
		Pessoa p = new Pessoa();
		PessoaId id = new PessoaId();
		id.setCpf("111111");
		p.setId(id);
		return p;
	}
	
	class PessoaId {
		String cpf;
		public String getCpf() { return cpf; }
		public void setCpf(String cpf) { this.cpf = cpf; }
	}
	class Pessoa {
		PessoaId id;
		public PessoaId getId() { return id; }
		public void setId(PessoaId id) { this.id = id; }
	}
	
}
