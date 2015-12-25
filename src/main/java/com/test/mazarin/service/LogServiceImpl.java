package com.test.mazarin.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mazarin.entity.Log;
import com.test.mazarin.repository.LoggerRepository;

@Service
@Transactional
public class LogServiceImpl implements LogService {

	@Autowired
	private LoggerRepository logRepository;

	@Override
	public void addLog(Log log) {
		logRepository.save(log);
	}

}
