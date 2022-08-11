package br.com.fuctura.escola.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fuctura.escola.controller.form.AlunoForm;
import br.com.fuctura.escola.controller.form.AtualizacaoAlunoForm;
import br.com.fuctura.escola.dto.AlunoDto;
import br.com.fuctura.escola.dto.DetalhesDoAlunoDto;
import br.com.fuctura.escola.model.Aluno;
import br.com.fuctura.escola.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<AlunoDto> listaAlunos() {
		List<Aluno> Alunos = alunoRepository.findAll();
		return AlunoDto.converter(Alunos);
	}

	@GetMapping("/listaPorNome")
	public List<AlunoDto> listaAlunoPorNome(String nomeAluno) {
		if (nomeAluno == null) {
			List<Aluno> Alunos = alunoRepository.findAll();
			return AlunoDto.converter(Alunos);
		} else {
			List<Aluno> Alunos = alunoRepository.findByNome(nomeAluno);
			return AlunoDto.converter(Alunos);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AlunoDto> cadastrar(@RequestBody @Valid AlunoForm form) {
		Aluno aluno = form.converterDTO();
		alunoRepository.save(aluno);
		
		return new ResponseEntity<AlunoDto>(new AlunoDto(aluno), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoAlunoDto> detalhar(@PathVariable Long id) {
		Optional<Aluno> Aluno = alunoRepository.findById(id);
		if (Aluno.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoAlunoDto(Aluno.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AlunoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoAlunoForm form) {
		Optional<Aluno> optional = alunoRepository.findById(id);
		if (optional.isPresent()) {
			Aluno Aluno = form.atualizar(id, alunoRepository);
			return ResponseEntity.ok(new AlunoDto(Aluno));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Aluno> optional = alunoRepository.findById(id);
		if (optional.isPresent()) {
			alunoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}