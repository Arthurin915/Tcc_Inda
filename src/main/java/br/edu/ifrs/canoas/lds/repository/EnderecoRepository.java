package br.edu.ifrs.canoas.lds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.domain.Endereco;
import br.edu.ifrs.canoas.lds.domain.User;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	List<Endereco> findAllByUser(User user);

}
