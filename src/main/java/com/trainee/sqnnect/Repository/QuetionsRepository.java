package com.trainee.sqnnect.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.sqnnect.Models.QueryTable;

/**
 * This is the main Repository extended by JpaRepository used by QuestionsServiceImpl to be able to store and use Objects of Entity 
 * @author Sahil Saiwal
 * @version 1.0
 */
@Repository
public interface QuetionsRepository extends JpaRepository<QueryTable, Integer> {

}
