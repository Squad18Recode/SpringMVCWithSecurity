package com.conect.coleta.squad18.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conect.coleta.squad18.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByName(String name);

}
