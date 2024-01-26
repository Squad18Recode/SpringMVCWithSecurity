package com.conect.coleta.squad18.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conect.coleta.squad18.dto.UsuarioDTO;
import com.conect.coleta.squad18.model.Usuario;
import com.conect.coleta.squad18.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public String userList(Model model) { 
		List<UsuarioDTO> usuario = service.findAllUsers();
		model.addAttribute("usuario", usuario);
		return "pages/usuarios/ListarUsuarios";
	}
	
	@GetMapping("/novo")
	public String showUserForm(Model model) { 
		UsuarioDTO usuario = new UsuarioDTO();
		model.addAttribute("usuario", usuario);
		return "pages/usuarios/Cadastro";
	}
	
	@Transactional
	@PostMapping("/novo/save")
	public String saveUsuario(@ModelAttribute("user") UsuarioDTO userDto, BindingResult result, Model model) { 
		Usuario existingUser = service.findUserByName(userDto.getName());
		
		if(existingUser != null && existingUser.getName() != null && !existingUser.getName().isEmpty()) { 
			result.rejectValue("name", null, "Esse usuário já existe.");
		}
		
		if(result.hasErrors()) { 
			model.addAttribute("usuario", userDto);
			return "/novo";
		}
		
		service.saveUser(userDto);
		return "redirect:/";
	}
}
