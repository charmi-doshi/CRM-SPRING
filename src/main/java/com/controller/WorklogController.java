package com.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bean.WorklogBean;
import com.dao.Worklog_Dao;

@RestController
public class WorklogController {

	@Autowired
	Worklog_Dao worklogDao;
	
	
	
	//worklog
	@GetMapping("/transaction/showworklog")
	public ResponseEntity<List<WorklogBean>> getWorklog() {

		System.out.println("get worklog called");
		List<WorklogBean> workLog = worklogDao.getWorklog();
		
		List<WorklogBean> workLogs  = new ArrayList<>();

		for (WorklogBean x : workLog) {
			System.out.println(x);
			workLogs.add(x);
		}

		return new ResponseEntity<List<WorklogBean>>(workLogs,HttpStatus.ACCEPTED);
	
}
	
	@PostMapping(value="/transaction/addworklog",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addWorkLog(@RequestBody WorklogBean logBean)
	{
		
		worklogDao.addWorklog(logBean);
		
		return new ResponseEntity<String>("Record Added",HttpStatus.CREATED);
	}

}
