package com.me;

import com.me.model.Candidate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper4 implements RowMapper<Candidate> {

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {

		Candidate can = new Candidate();

		can.setId(rs.getInt(1));
		can.setMobileNO(rs.getString(5));
		can.setAvtCode(rs.getString(2));
		can.setStatus(rs.getString(4));

		return can;
	}

}