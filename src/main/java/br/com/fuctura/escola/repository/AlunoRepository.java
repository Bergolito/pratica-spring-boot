package br.com.fuctura.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fuctura.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	List<Aluno> findByNome(String nome);
	
	Aluno findByCpf(String cpf);

}
