package com.trainee.sqnnect.Models;

import java.util.List;

import javax.persistence.*;

/**
 * QueryTable is a main Entity we'll be using to get our table where all the Questions and their Queries are stored
 * @author Sahil Saiwal
 * @version 1.0
 */

@Entity
@Table(name="sqnnect_table")
public class QueryTable {
		
	/**
	 * @param id  The Id of Questions
	 * @param Problems Questions stored in table
	 * @param Queries Queries stored in table for Questions
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)


	@Column(name="id")
	private int id;
	
	@Column(name="Problems", length=256)
	private String Problems;
	
	@Column(name="Queries", length=256)
	private String Queries;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProblems() {
		return Problems;
	}

	public void setProblems(String problems) {
		this.Problems = problems;
	}

	public String getQueries() {
		return Queries;
	}

	public void setQueries(String queries) {
		this.Queries = queries;
	}

	public void addAtribute(String string, List<QueryTable> listQueryTable) {
		// TODO Auto-generated method stub
		
	}

	public QueryTable(int id, String problems, String queries) {
		
		this.id = id;
		this.Problems = problems;
		this.Queries = queries;
	}
	
	public QueryTable() {}
}
