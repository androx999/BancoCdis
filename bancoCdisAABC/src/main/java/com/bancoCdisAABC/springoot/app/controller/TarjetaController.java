package com.bancoCdisAABC.springoot.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bancoCdisAABC.springoot.app.editors.CuentaPropetyEditor;
import com.bancoCdisAABC.springoot.app.models.dao.ICuentaDao;
import com.bancoCdisAABC.springoot.app.models.dao.ITarjetaDao;
import com.bancoCdisAABC.springoot.app.models.entity.Tarjeta;

@Controller
public class TarjetaController {

	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@Autowired
	private ICuentaDao cuentaDao;

	@Autowired
	private CuentaPropetyEditor cuentaEditor;
	
	@RequestMapping(value = "/tarjetas-lista", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de tarjetas");
		model.addAttribute("tarjetas", tarjetaDao.findAll());
		return "tarjetas-lista";
	}
		
		@RequestMapping(value = "/formatarjeta")
		public String crear(Map<String, Object> model ) {
			Tarjeta tarjeta = new Tarjeta();
			model.put("tajeta", tarjeta );
			model.put("titulo", "Llenar los datos de una tarjeta" );
			return "formtarjeta";
	}
		
		@RequestMapping(value = "/formtarjeta/{id}")
		public String editar(@PathVariable(value = "id") Long id, Map<String, Object>model) {
			Tarjeta tarjeta = null;
			
			if(id > 0) {
				tarjeta = tarjetaDao.findOne(id);
			}else {
				return "redirect:/index";
			}
			model.put("tarjeta", tarjeta);
			model.put("titulo", "Editar tarjeta");
			
			return "formtarjeta";
		}
		
		@RequestMapping(value = "/formtarjeta", method = RequestMethod.POST)
		public String guardar(@Valid Tarjeta tarjeta, BindingResult result, Model model, SessionStatus status) {
			
			if(result.hasErrors()) {
				model.addAttribute("titulo", "Forlumario de tarjeta");
				return "formtarjeta";
			}
			tarjetaDao.save(tarjeta);
			status.setComplete();
			
			return "redirect:index";
		}
		
		@RequestMapping(value="/eliminar/{id}")
		public String eliminar(@PathVariable(value = "id") Long id) {
			
			if(id > 0) {
				tarjetaDao.delete(id);
			}
			return "redirect:index";		
		}
		
		@RequestMapping(value="/eliminar/{id}")
	
	
}
