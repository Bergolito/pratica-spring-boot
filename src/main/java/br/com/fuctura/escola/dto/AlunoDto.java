package br.com.fuctura.escola.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fuctura.escola.model.Aluno;

public class AlunoDto {

	@NotNull @NotEmpty @Length(min = 11, max = 11)
	private String cpf;
	
	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	
	private String email;
	
	public AlunoDto(Aluno aluno) {
		this.cpf = aluno.getCpf();
		this.nome = aluno.getNome();
		this.email = aluno.getEmail();
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public static List<AlunoDto> converter(List<Aluno> alunos) {
		return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}

}
