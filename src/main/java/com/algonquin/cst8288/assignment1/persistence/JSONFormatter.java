package com.algonquin.cst8288.assignment1.persistence;

import java.io.IOException;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Concrete class that implements Formatter interface to convert data into JSON format
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class JSONFormatter implements Formatter{

	/**
	 * The method process the person object and extract the attributes 
	 * JSON format.
	 * 
     * @param person
     * @return 
     * @throws java.io.IOException
	 */
	@Override
	public String format(Employee person) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		try {
			return mapper.writeValueAsString(person);
		} catch (JsonProcessingException e) {
			throw new IOException(e);
		}
	}

}
