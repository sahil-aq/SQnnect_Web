package com.trainee.sqnnect.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trainee.sqnnect.Models.QueryTable;
import com.trainee.sqnnect.Repository.QuetionsRepository;

/**
 * The methods are defined in this file of QuetionsService
 * @author Sahil Saiwal
 * @version 1.0
 */

@Service
public class QuetionsServiceImpl implements QuetionsService{

	
	private QuetionsRepository quetionsRepo;
	
	public QuetionsServiceImpl(QuetionsRepository theQuetionsRepo) {
		quetionsRepo = theQuetionsRepo;
	}
	
	
	
	/**
	 * This method find all the objects of entity QueryTable and store it in quetionsRepo 
	 * @return all the objects of entity QueryTable
	 */
	@Override
	public List<QueryTable> findAll() {
		// TODO Auto-generated method stub
		return quetionsRepo.findAll();
	}
	
	/**
	 * This method find the object by the searching for the Id
	 * @param theId the Id for Questions
	 * @return the row as object for same ID
	 */
	@Override
	public QueryTable findById(int theId) {
		Optional<QueryTable> result = quetionsRepo.findById(theId);
		
		QueryTable theQuery = null;
		
		if(result.isPresent()) {
			theQuery =result.get();
		}
		else {
			throw new RuntimeException("Did not find Problem id - " + theId);
		}
		
		return theQuery;
	}


	

}
