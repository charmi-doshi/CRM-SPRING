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

import com.bean.WorklistBean;
import com.dao.Worklist_dao;

@RestController
 public class WorklistController {


	@Autowired
	Worklist_dao worklistDao;
	
	//worklist
	
		@GetMapping("/worklist/showlist")

		public ResponseEntity<List<WorklistBean>> getWorklist() {

			System.out.println("get worklist called");
			List<WorklistBean> workList = worklistDao.getWorklist();
			
			List<WorklistBean> workLists  = new ArrayList<>();

			for (WorklistBean x : workList) {
				System.out.println(x);
				workLists.add(x);
			}

			return new ResponseEntity<List<WorklistBean>>(workLists, HttpStatus.OK);
		}
		
		@PostMapping("/worklist/addworklist")
		public ResponseEntity<String> addWorkList(@RequestBody WorklistBean worklist)
		{
			System.out.println("add worklist called");
			worklistDao.addWorklist(worklist);
			
			return new ResponseEntity<String>("Record Added",HttpStatus.CREATED);
		}
		
		
}


