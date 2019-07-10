package ecco.onestopshop.components;


import org.springframework.data.repository.CrudRepository;

import ecco.onestopshop.models.QuestionMongo;

public interface QuestionsRepository extends CrudRepository<QuestionMongo, String>{ 
	
}
