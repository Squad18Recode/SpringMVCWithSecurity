package com.conect.coleta.squad18.services;

import java.util.List;

import com.conect.coleta.squad18.dto.UsuarioDTO;
import com.conect.coleta.squad18.model.Usuario;

public interface UsuarioService {

	List<UsuarioDTO> findAllUsers();
	
	void saveUser(UsuarioDTO userDTO);
	
	Usuario findUserByName(String name);
}
