package com.senai.cadastroendereco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastroendereco.entities.Pessoa;
import com.senai.cadastroendereco.repositories.PessoaRepository;

@Service
public class PessoaService {

	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//criar nova pessoa
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	//buscar pessoa por id
	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.findById(id).orElse(null);
	}
	
	//listar todas as pessoas
	public List<Pessoa> listarTodas() {
		return pessoaRepository.findAll();
	}
	
	//excluir uma pessoa
	public void deletarPorId(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	//buscar pessoa por email
	public Pessoa buscarPorEmail(String email) {
		return pessoaRepository.findByEmail(email);
	}
	
	//verificar email e senha
	public Pessoa autenticarPessoa(String email, String senha) {
		
		//verifica a existencia do email
		Pessoa pessoa = pessoaRepository.findByEmail(email);
		
		//
		if (pessoa != null && pessoa.getSenha().equals(senha)) {
			return pessoa;
		} else {
			return null;
		}
	}
}
