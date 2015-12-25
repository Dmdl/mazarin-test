package com.test.mazarin.service;

import com.test.mazarin.entity.Log;
/**
 * 
 * @author lakmal
 * Database logging related functions
 */
public interface LogService {

	/**
	 * Save log message
	 * 
	 * @param log log object
	 */
	public void addLog(Log log);
}
