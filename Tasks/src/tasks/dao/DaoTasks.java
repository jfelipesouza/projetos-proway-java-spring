package tasks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tasks.entity.Tasks;
import tasks.entity.Users;
import tasks.interfaces.ICrud;
import tasks.interfaces.ICrudTasks;
import tasks.utils.TasksConnect;

public class DaoTasks implements ICrudTasks<Tasks>{

	@Override
	public boolean create(Tasks obj) {
		String sql = "insert into tasks(taskname, description,userreference) values(?,?,?)";
		Connection con = TasksConnect.connect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getTaskName());
			stm.setString(2, obj.getDescription());
			stm.setInt(3,obj.getUserreference());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	@Override
	public boolean update(Tasks obj) {
		String sql = "update tasks set"
				+ "taskname = ?," 
				+ "description = ?" 
				+ "where userreference = ? ";
		Connection con = TasksConnect.connect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getTaskName());
			stm.setString(2, obj.getDescription());
			stm.setInt(3, obj.getUserreference());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public void delete(int id) {
		String sql = "delete from tasks where id=?";
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
	public List<Tasks> read(int id) {
		List<Tasks> tasks = new ArrayList<>();
		String sql = "select * from tasks where userreference = ?";
		Connection con = TasksConnect.connect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Tasks task = new Tasks();
				task.setId(rs.getInt("id"));
				task.setUserreference(rs.getInt("userreference"));
				task.setTaskName(rs.getString("taskname"));
				task.setDescription(rs.getString("description"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			System.out.println("erro: " + e);
		}
		return tasks;
	}

	@Override
	public List<Tasks> readAll(int user) {
		List<Tasks> tasks = new ArrayList<>();
		String sql = "select * from tasks";
		Connection con = TasksConnect.connect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Tasks task = new Tasks();
				task.setId(rs.getInt("id"));
				task.setUserreference(rs.getInt("userreference"));
				task.setTaskName(rs.getString("taskname"));
				task.setDescription(rs.getString("description"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			System.out.println("erro: " + e);
		}
		return tasks;
	}


	
	
}
