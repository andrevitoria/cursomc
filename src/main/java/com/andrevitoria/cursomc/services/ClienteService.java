package com.andrevitoria.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrevitoria.cursomc.domain.Cliente;
import com.andrevitoria.cursomc.repositories.ClienteRepository;
import com.andrevitoria.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	public Cliente buscar (Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		//return obj.orElse(null);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: "+id + ", Tipo: "+Cliente.class.getName() ));
	}
}
