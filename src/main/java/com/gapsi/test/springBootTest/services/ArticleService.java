package com.gapsi.test.springBootTest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gapsi.test.springBootTest.models.Article;
import com.gapsi.test.springBootTest.repositories.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository repository;
	
	public Iterable<Article> getArticle() {
		
		Iterable<Article> articles = repository.findAll();
		return articles;
	}
	
	public Article getArticleById(String id) {
		
		Article article = repository.findById(id).orElseThrow();;
					
		return article;

	}
	
	public Article putArticle(String id, String desc, String modelo) {
				
		Article article = repository.findById(id).orElseThrow();
		article.setDescripcion(desc);
		article.setModelo(modelo);
		repository.save(article);
			
		return article;
	}
}
