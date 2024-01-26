package com.conect.coleta.squad18.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.conect.coleta.squad18.model.Doadores;
import com.conect.coleta.squad18.model.Reciclaveis;
import com.conect.coleta.squad18.services.DoadoresService;
import com.conect.coleta.squad18.services.ReciclaveisService;

@Controller
@RequestMapping("/doadores")
public class DoadoresController {

	@Autowired
	private DoadoresService doadoresService;

	@Autowired
	private ReciclaveisService reciclaveisService;

	@GetMapping
	public String listarDoadores(Model model) {
		List<Doadores> doadores = doadoresService.getAllDoadores();
		model.addAttribute("doadores", doadores);
		return "listarDoadores";
	}

	@GetMapping("/novo")
	public String showForm(Model model) {
		Doadores doador = new Doadores();
		List<Reciclaveis> reciclaveis = reciclaveisService.getAllReciclaveis();
		model.addAttribute("doador", doador);
		model.addAttribute("reciclaveis", reciclaveis);
		return "./cadastroDoadores/segundo.html";
	}

	@PostMapping("/save")
	public String saveDoadores(@ModelAttribute("doador") Doadores doador, @RequestParam Set<Long> reciclavel) {
		doador.setReciclaveis(
				reciclavel.stream().map(reciclaveisService::getReciclavelById).collect(Collectors.toSet()));
		doadoresService.saveDoador(doador, reciclavel);
		return "redirect:/doadores";
	}

	@GetMapping("/editar/{idDoador}")
	public String ShowUpdateForm(@PathVariable("idDoador") Long idDoador, Model model) {
		Doadores doador = doadoresService.getDoadorById(idDoador);
		model.addAttribute("doador", doador);
		model.addAttribute("reciclaveis", reciclaveisService.getAllReciclaveis());
		return "./editarDoadores/editarDoador";
	}

	@PostMapping("/editar/{idDoador}")
	public String updateDoadores(@PathVariable("idDoador") Long idDoador,
			@ModelAttribute("doador") Doadores doador) {
		doadoresService.updateDoador(idDoador, doador);
		return "redirect:/doadores";
	}

	@GetMapping("/deletar/{idDoador}")
	public String deleteDoadores(@PathVariable Long idDoador) {
		doadoresService.deleteDoador(idDoador);
		return "redirect:/doadores";

	}
}
