package com.gapsi.test.springBootTest.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gapsi.test.springBootTest.models.Article;

@Repository
public interface ArticleRepository extends CrudRepository < Article, String > {

}
