 package com.user.web.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.user.web.dao.UserDao;
import com.user.web.domain.User;
import com.user.web.mapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
	 * jdbcTemplate; }
	 */
	@Override
	public int create(User user) {
		String query = "INSERT INTO USER_SCHEMA.USERS VALUES(" + user.getUserId() + ",'" + user.getFirstName() + "','"
				+ user.getLastName() + "','" + user.getMiddleName() + "')";
		return jdbcTemplate.update(query);
	}

	public Boolean saveUserByPreparedStatement(User user) {
		String query = "INSERT INTO USER_SCHEMA.USERS VALUES(?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setInt(1, user.getUserId());
				ps.setString(2, user.getFirstName());
				ps.setString(3, user.getLastName());
				ps.setString(4, user.getMiddleName());  

				return ps.execute();

			}
		});
	}

	@Override
	public List<User> findAllUsers() {
		String selectQuery = "SELECT * FROM USER_SCHEMA.USERS";
		return jdbcTemplate.query(selectQuery, new UserRowMapper());
	}

}
