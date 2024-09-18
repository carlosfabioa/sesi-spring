package com.sesi.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sesi.login.model.Usuario;
import com.sesi.login.repository.UsuarioRepository;

public class DetalhesUsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	
	@Override
	public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		
		
		return new org.springframework.security.core.userdetails.User(
				usuario.getNomeUsuario(),
				usuario.getSenha(),
				null);
	}


	

}
