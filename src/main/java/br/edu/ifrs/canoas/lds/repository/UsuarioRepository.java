package br.edu.ifrs.canoas.lds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.domain.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{//objeto dominio de referencia e tipo de chave(id)
	Usuario findByEmail(String email);
	List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
