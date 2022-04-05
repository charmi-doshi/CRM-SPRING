package com.controller;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CRM_bean;


import com.dao.CRM_dao;
import com.dao.FinyearDao;



@RestController
 public class CRM_Controller {

	@Autowired
	FinyearDao finyeardao;

	@Autowired
	CRM_dao crmdao;



	// client

//	@PostMapping(value = "/client/addclient")
//
//	public ResponseEntity<String> addClient(@RequestBody CRM_bean crmbean) {
//		try {
//			System.out.println("crmcont");
//			crmdao.addClient(crmbean);
//			// throws sqlexception
//			return new ResponseEntity<String>("Record added...", HttpStatus.CREATED);
//		} catch (Exception e) {
//			System.out.println(e);
//			System.out.println("error with primary key constraint check your client_Type");
//			return new ResponseEntity<String>("error...", HttpStatus.BAD_REQUEST);
//
//		}
//
//	}

	@GetMapping("/client/showclient")

	public ResponseEntity<List<CRM_bean>> getClient() {

		System.out.println("method called");
		List<CRM_bean> clientList = crmdao.getClient();
		
		List<CRM_bean> clients = new ArrayList<>();

		for (CRM_bean x : clientList) {
			System.out.println(x);
			clients.add(x);
		}

		return new ResponseEntity<List<CRM_bean>>(clients, HttpStatus.OK);
	}

	@GetMapping("/client/showclient/{cName}")
	public ResponseEntity<CRM_bean> getClientByName(@PathVariable("cName") String cName) {
		System.out.println("search--> " + cName);
		CRM_bean crmbean = crmdao.getClientByName(cName);
		return new ResponseEntity<CRM_bean>(crmbean, HttpStatus.OK);
	}

	@PostMapping(value = "/client/addclient",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addClient(@RequestBody CRM_bean clientBean)
	{
	 
		System.out.println(clientBean.getType());
		crmdao.addClient(clientBean);
		//return new ResponseEntity<EmployeeBean>(new EmployeeBean(),HttpStatus.CREATED);
		System.out.println(clientBean);
		return new ResponseEntity<String>("Record Added",HttpStatus.CREATED);
	}
	
	
	
	

	
	//worklist
	
//	@GetMapping("/worklist/showlist")
//
//	public ResponseEntity<List<WorklistBean>> getWorklist() {
//
//		System.out.println("get worklist called");
//		List<WorklistBean> workList = worklistDao.getWorklist();
//		
//		List<WorklistBean> workLists  = new ArrayList<>();
//
//		for (WorklistBean x : workList) {
//			System.out.println(x);
//			workLists.add(x);
//		}
//
//		return new ResponseEntity<List<WorklistBean>>(workLists, HttpStatus.OK);
//	}
	// end
}
