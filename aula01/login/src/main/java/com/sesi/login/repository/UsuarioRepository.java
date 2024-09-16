package com.sesi.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.login.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByNomeUsuario(String nomeUsuario);
}
