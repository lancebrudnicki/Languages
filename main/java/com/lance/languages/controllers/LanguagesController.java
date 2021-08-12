package com.lance.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lance.languages.models.Language;
import com.lance.languages.services.LanguageService;


@Controller
public class LanguagesController {
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;		
	}
	
	
	//___________________ Routes__________________
	
	
	// index route using model to c:out our object to the page
	
	
	@RequestMapping("/languages")
	public String index( @ModelAttribute("language") Language language,Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	
	// @Valid allows us to validate the data
	// the if else statement lets us see the errors if any thing happens during the validation process 
	
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/index.jsp";
		}else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	//pass id via the url and finds the object in our database through the languageSerivce
	
	
	@RequestMapping(value="/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "languages/show.jsp";
	}
	
	@RequestMapping(value="/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "languages/edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/edit.jsp";
		}else {
//			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String destory(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	
	
	
}
