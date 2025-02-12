package com.gapsi.test.springBootTest.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gapsi.test.springBootTest.http.Response;
import com.gapsi.test.springBootTest.models.Article;
import com.gapsi.test.springBootTest.services.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	ArticleService articleService;
	
	@GetMapping("/articles")
	public Response<Iterable<Article>> getArticle(){
		try {
			Iterable<Article> articles = articleService.getArticle();
			return new Response<Iterable<Article>>(HttpStatus.OK.value(), "Operacion exitosa", true, articles);
		}
		catch (Exception e) {
			System.out.println("ERROR: \n" + e.getMessage());
			return new Response<Iterable<Article>>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Operacion fallida. No fue posible obtener la lista de articulos");
		}
	}
	
	@GetMapping("/articles/{id}")
	public Response<Article> getArticle(@PathVariable("id") String id){
		try {
			Article article = articleService.getArticleById(id);
			return new Response<Article>(HttpStatus.OK.value(), "Operacion exitosa", true, article);
		}
		catch (NoSuchElementException nsee){
			System.out.println("ERROR: \n" + nsee.getMessage());
			return new Response<Article>(HttpStatus.NOT_FOUND.value(), "Operacion fallida. Articulo no encontrado");
		}
		catch (Exception e){
			return new Response<Article>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Operacion fallida. No fue posible obtener el articulo deseado");
		}
	}
	
	@PutMapping("/articles/{id}")
	public Response<Article> putArtticle(@RequestBody Article article, @PathVariable("id") String id) {
		try {
			Article updArticle = articleService.putArticle(id, article.getDescripcion(), article.getModelo());
			return new Response<Article>(HttpStatus.OK.value(), "Operacion exitosa. Articulo actulizado exitosamente", true, updArticle);
		}
		catch (NoSuchElementException nsee){
			System.out.println("ERROR: \n" + nsee.getMessage());
			return new Response<Article>(HttpStatus.NOT_FOUND.value(), "Operacion fallida. Articulo no encontrado");
		}
		catch (Exception e){
			return new Response<Article>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Operacion fallida. No fue posible actualizar el articulo deseado");
		}		
		
	}
}
