package com.cpfanalyzer.controllers;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cpfanalyzer.exceptions.HandlerException;
import com.cpfanalyzer.models.RestrictedList;
import com.cpfanalyzer.repository.CpfAnalyzerRepository;

import jakarta.validation.Valid;


@RestController
@Validated
public class RestrictedListController {
	
	@Autowired
	CpfAnalyzerRepository cpfAnalyzerRepository;

	@PostMapping("/cpf")
	public ResponseEntity<?> addCpf(@RequestBody @Valid RestrictedList CPF) {
		RestrictedList newCPF = cpfAnalyzerRepository.findByCPF(CPF.getCPF());
		if (newCPF != null) {
			HandlerException exception = new HandlerException();
			exception.setType("ExistsCpfException");
	        exception.setMessage("CPF already exists");
	        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	       }
		else {
			try {
				 RestrictedList list = cpfAnalyzerRepository.save(new RestrictedList(CPF.getCPF()));
						 
				return ResponseEntity.status(HttpStatus.CREATED)
						.contentType(MediaType.APPLICATION_JSON)
						.body(list);
			}catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
		}	
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<?> checkCpf(@PathVariable("cpf") @CPF String CPF) {
		RestrictedList list = cpfAnalyzerRepository.findByCPF(CPF);
		if (list == null) {
			HandlerException exception = new HandlerException();
			exception.setType("NotFoundCpfException");
	         exception.setMessage("CPF not found");
	         return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	     }
	    return new ResponseEntity<>(list, HttpStatus.OK); 

	}
	
	@GetMapping("/cpf")
	public List<RestrictedList> findAll() {
		return cpfAnalyzerRepository.findAll();
	}
	
	@DeleteMapping("/cpf/{cpf}")
	  public ResponseEntity<?> removeCpf(@PathVariable ("cpf") @CPF String CPF) {
		RestrictedList list = cpfAnalyzerRepository.findByCPF(CPF); 
		if (CPF == null) {
			HandlerException exception = new HandlerException();
			exception.setType("NotFoundCpfException");
	        exception.setMessage("CPF not found");
	        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
		}
		try {
			cpfAnalyzerRepository.deleteById(list.getId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) { 
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	 	@ExceptionHandler((MethodArgumentNotValidException.class))
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	 	public HandlerException handleException(MethodArgumentNotValidException ex) {
	 		HandlerException e = new HandlerException();
	 		HandlerException result = e.handleException(ex.getStatusCode());
	 		return result;
	    }
	 	
}













