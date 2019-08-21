package ecco.onestopshop.models.repositories;

import org.springframework.data.repository.CrudRepository;

import ecco.onestopshop.models.TechDecisionAndProgressionEvaluationData.QuestionsAdvance;

public interface QuestionsAdvanceRepository extends CrudRepository<QuestionsAdvance, String>{ 
	
}