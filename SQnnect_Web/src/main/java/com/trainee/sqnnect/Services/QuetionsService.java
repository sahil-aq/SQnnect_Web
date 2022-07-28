package com.trainee.sqnnect.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trainee.sqnnect.Models.QueryTable;

/**
 * This is the interface where we declare all the methods we are required and defined in QuetionsServiceImpl
 * @author Sahil Saiwal
 * @version 1.0
 */

@Service
public interface QuetionsService {

	public List<QueryTable> findAll();
	
	public QueryTable findById(int theId);
}
