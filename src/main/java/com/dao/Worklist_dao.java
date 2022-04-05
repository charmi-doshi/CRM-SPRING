package com.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.bean.WorklistBean;


@Repository
public class Worklist_dao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final static class WorklistMapper implements RowMapper<WorklistBean>
	{
		@Override
		public WorklistBean mapRow(ResultSet rs,int rowNum) throws SQLException {
			WorklistBean worklistBean = new WorklistBean();
//			worklistBean.setClient_type(rs.getInt("client_type"));
//			worklistBean.setTask_id(rs.getInt("task_id"));
			
			worklistBean.setTask_name(rs.getString("task_name"));
			worklistBean.setIndividual(rs.getString("individual"));
			worklistBean.setIndividual_2(rs.getString("individual_2"));
			worklistBean.setPartner(rs.getString("partner"));
			worklistBean.setProprietor(rs.getString("proprietor"));
			worklistBean.setCompany(rs.getString("company"));
			worklistBean.setFirm(rs.getString("firm"));
			worklistBean.setTrust(rs.getString("trust"));
			worklistBean.setCoop_Society(rs.getString("coop_Society"));
			
			
			return worklistBean;
		}
	}

	//add
	public int addWorklist(WorklistBean worklistBean) {

		System.out.println("add worklist...");
		
		return jdbcTemplate.update("insert into worklist(client_type,task_id,client_flag) values(?,?,1)",
				worklistBean.getClient_type(),worklistBean.getTask_id());
	}
	
	//get
		public List<WorklistBean> getWorklist() {
			return jdbcTemplate.query("select task_name,\r\n"
					+ "	max(CASE when(name='Individual') then client_flag else NULL end)as Individual,\r\n"
					+ "	max(CASE when(name='Individual 2') then client_flag else NULL end)as Individual_2,\r\n"
					+ "	max(CASE when(name='Partner') then client_flag else NULL end)as Partner,\r\n"
					+ "	max(CASE when(name='Proprietor') then client_flag else NULL end)as Proprietor,\r\n"
					+ "	max(CASE when(name='Firm') then client_flag else NULL end)as Firm,\r\n"
					+ "	max(CASE when(name='Company') then client_flag else NULL end)as Company,\r\n"
					+ "	max(CASE when(name='Trust') then client_flag else NULL end)as Trust,\r\n"
					+ "	max(CASE when(name='Co-op Society') then client_flag else NULL end)as Coop_Society\r\n"
					+ "from view1 \r\n"
					+ "GROUP BY task_name\r\n"
					+ "ORDER BY task_name;", new WorklistMapper());
			
		}
}
