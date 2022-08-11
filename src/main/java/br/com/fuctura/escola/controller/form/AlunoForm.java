package br.com.fuctura.escola.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import br.com.fuctura.escola.model.Aluno;

public class AlunoForm {

	@NotNull @NotEmpty @Length(min = 11, max = 11)
	private String cpf;
	
	@NotNull @NotEmpty  @Length(min = 5)
	private String nome;
	
	@Nullable
	private String email;
	
	@Nullable
	private String fone;

	@Nullable
	private String dataNasc;
	
	@Nullable
	private String tipo;

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getFone() {
		return fone;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public String getTipo() {
		return tipo;
	}
	
	public Aluno converterDTO() {
		Aluno aluno = new Aluno(cpf, nome, email, fone, tipo); 
		return aluno;
	}

}
