package br.com.fuctura.escola.model.teste;

import br.com.fuctura.escola.model.Aluno;

public class AlunoTeste {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("11111111111", "Aluno 01", "aluno01@escola.com", "81 3271-1234", "CONVENCIONAL");
		Aluno a2 = new Aluno("22222222222", "Aluno 02", "aluno02@escola.com", "81 3271-1234", "CONVENCIONAL");
		Aluno a3 = new Aluno("33333333333", "Aluno 03", "aluno03@escola.com", "81 3271-1234", "MONITOR");

		Aluno a4 = new Aluno("11111111111", "Aluno 01", "aluno01@escola.com", "81 3271-1234", "CONVENCIONAL");

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		
		System.out.println(a1.equals(a4));
	}
}
