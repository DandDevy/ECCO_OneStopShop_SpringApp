package ecco.onestopshop.models.repositories;

import org.springframework.data.repository.CrudRepository;

import ecco.onestopshop.models.QuestionsAdvance;
import ecco.onestopshop.models.QuestionsBeginner;

public interface QuestionsAdvanceRepository extends CrudRepository<QuestionsAdvance, String>{ 
	
}