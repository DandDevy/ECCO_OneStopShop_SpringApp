package ecco.onestopshop.models.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecco.onestopshop.models.QuestionsBeginner;


public interface QuestionsRepository extends CrudRepository<QuestionsBeginner, String>{ 
	
}
