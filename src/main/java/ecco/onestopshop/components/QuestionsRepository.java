package ecco.onestopshop.components;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecco.onestopshop.models.Questions;


public interface QuestionsRepository extends CrudRepository<Questions, String>{ 
	
}
