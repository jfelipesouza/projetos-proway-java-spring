package tasks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tasks.entity.Users;
import tasks.interfaces.ICrud;
import tasks.utils.TasksConnect;

public class DaoUsers implements ICrud<Users> {

	@Override
	public boolean create(Users obj) {
		String sql = "insert into users(username, email) values(?,?)";
		Connection con = TasksConnect.connect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getUserName());
			stm.setString(2, obj.getEmail());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	@Override
	public boolean update(Users obj) {
		String sql = "update users set" + "username = ?," + "email = ?" + "where id = ? ";
		Connection con = TasksConnect.connect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getUserName());
			stm.setString(2, obj.getEmail());
			stm.setInt(3, obj.getId());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public void delete(int id) {
		String sql = "delete from users where id=?";
		Connection con = TasksConnect.connect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			stm.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Users read(int id) {
		String sql = "select * from users where id = ?";
		Connection con = TasksConnect.connect();
		Users user = new Users();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public List<Users> read() {
		List<Users> users = new ArrayList<>();
		String sql = "select * from users";
		Connection con = TasksConnect.connect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("erro: " + e);
		}
		return users;
	}

}
