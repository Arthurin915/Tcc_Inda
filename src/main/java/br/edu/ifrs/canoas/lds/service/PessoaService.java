package br.edu.ifrs.canoas.lds.service;

import br.edu.ifrs.canoas.lds.domain.PessoaFisica;
import br.edu.ifrs.canoas.lds.domain.PessoaJuridica;
import br.edu.ifrs.canoas.lds.domain.User;
import br.edu.ifrs.canoas.lds.repository.RoleRepository;
import br.edu.ifrs.canoas.lds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PessoaService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public PessoaJuridica save(PessoaJuridica pessoaJuridica) {
        pessoaJuridica.setUsername(pessoaJuridica.getEmail());
        pessoaJuridica.getRoles().add(roleRepository.getOne(2L));
        pessoaJuridica.setPassword(passwordEncoder.encode(pessoaJuridica.getPassword()));
        return userRepository.save(pessoaJuridica);
    }

    public PessoaFisica save(PessoaFisica pessoaFisica) {
        pessoaFisica.setUsername(pessoaFisica.getEmail());
        pessoaFisica.getRoles().add(roleRepository.getOne(1L));
        pessoaFisica.setPassword(passwordEncoder.encode(pessoaFisica.getPassword()));
        return userRepository.save(pessoaFisica);
    }

    public User save(User pessoa) {
        return userRepository.save(pessoa);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(User user) {
        return userRepository.findByEmail(user.getEmail());
    }

    public List<User> pesquisa(String nome) {
        return userRepository.findAllByNomeContainingIgnoreCase(nome);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User getId(Long id) {
        return userRepository.getOne(id);
    }

    public List<User> pessoasJuridicas(String nome) {
        List<User> usuarios = userRepository.findAllByNomeContainingIgnoreCase(nome);
        List<User> retorno = new ArrayList<>();
        for (User user : usuarios) {
            if (user instanceof PessoaJuridica) {
                retorno.add(user);
            }
        }
        return retorno;
    }

    public Optional<User> findByNome(String nome) {
        return userRepository.findByNome(nome);
    }

    public List<PessoaJuridica> buscaCategoria(String categoria) {
        return this.userRepository.findAllByCategoria(categoria);
    }
}