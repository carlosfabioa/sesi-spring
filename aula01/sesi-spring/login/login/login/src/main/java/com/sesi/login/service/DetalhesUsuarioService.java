package com.sesi.login.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sesi.login.model.Papel;
import com.sesi.login.model.Usuario;
import com.sesi.login.repository.UsuarioRepository;

@Service
public class DetalhesUsuarioService implements UserDetailsService{
	 @Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);
		if(usuario ==null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		return new org.springframework.security.core.userdetails.User(usuario.getNomeUsuario(),
				usuario.getSenha(),
				mapearPapeisParaPermissoes(usuario.getPapeis()));
				
	}
	
	private Collection<? extends GrantedAuthority> mapearPapeisParaPermissoes(Set<Papel> papeis){
		return papeis.stream()
				.map(papel -> new SimpleGrantedAuthority(papel.getNomePapel()))
				.collect(Collectors.toList());
	}
	
	
}
