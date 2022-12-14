package br.com.fuctura.escola.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fuctura.escola.dto.AlunoDto;
import br.com.fuctura.escola.model.Aluno;

@RestController
@RequestMapping("/primeiro")
public class PrimeiroController {

	@GetMapping("/listar1")
	public List<Aluno> listar1(){
		Aluno aluno1 = new Aluno("11111111111", "Aluno 1", "aluno1@escola.com");
		Aluno aluno2 = new Aluno("22222222222", "Aluno 2", "aluno2@escola.com");
		Aluno aluno3 = new Aluno("33333333333", "Aluno 3", "aluno3@escola.com");
		
		return Arrays.asList(aluno1, aluno2, aluno3);
	}
	
	@GetMapping("/listar2")
	public List<AlunoDto> listar2(){
		Aluno aluno1 = new Aluno("11111111111", "Aluno 1", "aluno1@escola.com");
		Aluno aluno2 = new Aluno("22222222222", "Aluno 2", "aluno2@escola.com");
		Aluno aluno3 = new Aluno("33333333333", "Aluno 3", "aluno3@escola.com");
		
		List<Aluno> listaAlunos = Arrays.asList(aluno1, aluno2, aluno3);
		
		List<AlunoDto> listaAlunosDTO = listaAlunos.stream().map(AlunoDto::new).collect(Collectors.toList());		

		return listaAlunosDTO;
	}
	
}
