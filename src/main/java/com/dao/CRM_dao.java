package com.dao;


import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.CRM_bean;

@Repository
public class CRM_dao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static class ClientMapper implements RowMapper<CRM_bean>
	{
		@Override
		public CRM_bean mapRow(ResultSet rs,int rowNum) throws SQLException {
			
			CRM_bean crmbean = new CRM_bean();
			crmbean.setId(rs.getInt("Id"));
			crmbean.setName(rs.getString("name"));
			crmbean.setAddress(rs.getString("address"));
			crmbean.setMobile1(rs.getInt("contact1"));
			crmbean.setMobile2(rs.getInt("contact2"));
			crmbean.setKeyperson(rs.getString("keyperson"));
			crmbean.setEmail(rs.getString("email"));
			crmbean.setType(rs.getInt("client_type"));
			crmbean.setStatus(rs.getString("status"));
			return crmbean;
		}
	}
	
	//add
		public int addClient(CRM_bean crmbean)
		{
			System.out.println("add dao...");
			
			return jdbcTemplate.update("insert into client_master(name,address,contact1,contact2,keyperson,email,status,client_type) values(?,?,?,?,?,?,?,?)",
					crmbean.getName(),crmbean.getAddress(),crmbean.getMobile1(),crmbean.getMobile2(),crmbean.getKeyperson(),
					crmbean.getEmail(),crmbean.getStatus(),crmbean.getType());
			
		}
	//get
	public List<CRM_bean> getClient() {
		return jdbcTemplate.query("select * from client_master", new ClientMapper());
		
	}
	
	public CRM_bean getClientByName(String cName) {
		
		return jdbcTemplate.queryForObject("select * from client_master where name='"+cName+"'", new ClientMapper());
		
	}
	public List<CRM_bean> getAllClients() {

		return jdbcTemplate.query("select * from client_master", new ResultSetExtractor<List<CRM_bean>>() {

			public List<CRM_bean> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<CRM_bean> list = new ArrayList<CRM_bean>();
				while (rs.next()) {

					CRM_bean crmbean = new CRM_bean();
					crmbean.setName(rs.getString("name"));
					crmbean.setAddress(rs.getString("address"));
					crmbean.setMobile1(rs.getInt("contact1"));
					crmbean.setMobile2(rs.getInt("contact2"));
					crmbean.setKeyperson(rs.getString("keyperson"));
					crmbean.setEmail(rs.getString("email"));
					crmbean.setType(rs.getInt("client_type"));
					crmbean.setStatus(rs.getString("status"));
					
					list.add(crmbean);

				}

				return list;
			}

		});

	}
	//end
}
