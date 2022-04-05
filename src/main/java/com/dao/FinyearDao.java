package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.FinyearBean;

@Repository
public class FinyearDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	private final static class FinyearMapper implements RowMapper<FinyearBean>{
			
		@Override
		public FinyearBean mapRow(ResultSet rs,int rowNum) throws SQLException{
			FinyearBean finyearbean = new FinyearBean();
			finyearbean.setId(rs.getInt("ID"));
			finyearbean.setYearName(rs.getString("shortname"));
			finyearbean.setStartDate(rs.getDate("startdate"));
			finyearbean.setEndDate(rs.getDate("enddate"));
			finyearbean.setCurrentFlag(rs.getBoolean("current_flag"));
			return finyearbean;
		} 
	}
	//add finyear
	public int addFinyear(FinyearBean finyearbean)
	{
		return jdbcTemplate.update("insert into fin_year(shortname,startdate,enddate,current_flag) values(?,?,?,?)",
				finyearbean.getYearName(),finyearbean.getStartDate(),finyearbean.getEndDate(),finyearbean.isCurrentFlag());
	}
	
	//get financial year
	public FinyearBean getYearById() {
		System.out.println("fin_year");
		return jdbcTemplate.queryForObject("select * from fin_year",new FinyearMapper());
		
	}
	//end
}
