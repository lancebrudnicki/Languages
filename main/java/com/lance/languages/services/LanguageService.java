package com.lance.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lance.languages.models.Language;
import com.lance.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	// adding the Language repository as a dependency 
	private final LanguageRepository languageRepository;

	// constructor 
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	// finds all the languages and returns them in a list
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	// creates an object language and save it in the database
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	
	// gets one language
	public Language findLanguage(Long id) {
		//
		
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}else {
			return null;
		}
	}
	
	public Language updateLanguage(Long id, String name, String creator, String version) {
		Language language = findLanguage(id);
		language.setName(name);
		language.setCreator(creator);
		language.setVersion(version);
		
		return languageRepository.save(language);
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
	
	
	
}
