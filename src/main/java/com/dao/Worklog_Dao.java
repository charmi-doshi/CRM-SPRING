package com.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.bean.WorklogBean;


@Repository
public class Worklog_Dao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final static class WorklogMapper implements RowMapper<WorklogBean>
	{
		@Override
		public WorklogBean mapRow(ResultSet rs,int rowNum) throws SQLException {
			WorklogBean worklogBean = new WorklogBean();
			worklogBean.setClient_name(rs.getString("client_name"));
			worklogBean.setFinyear(rs.getString("finyear"));
			worklogBean.setEntry_date(rs.getString("entry_date"));
			worklogBean.setWork_item(rs.getString("work_item"));
			worklogBean.setHours(rs.getInt("hours"));
			worklogBean.setLocation(rs.getString("location"));
			worklogBean.setStatus(rs.getString("status"));
			worklogBean.setRemarks(rs.getString("remarks"));
			
			return worklogBean;
		}
	}
	
	//add
		public int addWorklog(WorklogBean worklogBean) {

			System.out.println("add worklog...");
			
			return jdbcTemplate.update(" insert into worklog(client_name,finyear,entry_date,work_item,hours,location,status,remarks) values(?,?,?,?,?,?,?,?)",
					worklogBean.getClient_name(),worklogBean.getFinyear(),worklogBean.getEntry_date(),worklogBean.getWork_item(),worklogBean.getHours(),
					worklogBean.getLocation(),worklogBean.getStatus(),worklogBean.getRemarks());
		}
		
		//get
			public List<WorklogBean> getWorklog() {
				return jdbcTemplate.query("select * from worklog", new WorklogMapper());
				
			}
	
}
