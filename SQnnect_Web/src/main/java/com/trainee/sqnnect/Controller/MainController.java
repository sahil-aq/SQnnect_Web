package com.trainee.sqnnect.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trainee.sqnnect.Models.QueryTable;
import com.trainee.sqnnect.Services.QuetionsService;

/**
 * This is the main controller for fetching data and firing queries
 * @author Sahil Saiwal
 * @version 1.0
 */

@Controller
public class MainController {

	@Autowired
	private QuetionsService quetionService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public MainController(QuetionsService thequeService) {
		quetionService = thequeService;
	}
	
	/**
	 * @return HTML page for forwarding to the Questions page
	 */
	@GetMapping(path="/sqnnect")
	public String show() {
		return "start";
	}
	
	/**
	 * This method is get all questions from DataBase and use model attribute to reflect data on HTML page
	 * @param theModel adds an attribute named message defined in the controller class.
	 * @return HTML page for all the Questions list and buttons to fire queries 
	 */
	@GetMapping(path="/list")
	public String ListQuetions(Model theModel) {
		
		// get questions from db
		List<QueryTable> theQtable = quetionService.findAll();
		System.out.println(new ResponseEntity<>(theQtable,HttpStatus.OK));
		// add to the spring model
		theModel.addAttribute("Quetions", theQtable);
		
		return "quetions";
	}
	int temp;
	String Qry;
	
	/**
	 * This method take input as id from url to be able to run queries using Id and show data
	 * @param id the id from the url for Questions
	 * @return data from the queries fired
	 */
	@RequestMapping(value="/list/id",path="/list/id",method=RequestMethod.GET )
	public ResponseEntity<Object> querybyId(Model model, @RequestParam(value="id") String id ) {
		
		temp = Integer.parseInt(id);
		QueryTable theQueryRow = quetionService.findById(temp);
		Qry = theQueryRow.getQueries();
		Object Ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(Ans,HttpStatus.OK);
	}
}
