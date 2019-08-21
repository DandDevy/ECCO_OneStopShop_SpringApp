package ecco.onestopshop.models.repositories;


import org.springframework.data.repository.CrudRepository;

import ecco.onestopshop.models.TechDecisionAndProgressionEvaluationData.QuestionsBeginner;


public interface QuestionsBeginnerRepository extends CrudRepository<QuestionsBeginner, String>{ 
	
}
