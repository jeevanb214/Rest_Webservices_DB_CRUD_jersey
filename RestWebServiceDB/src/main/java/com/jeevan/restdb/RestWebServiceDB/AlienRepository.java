package com.jeevan.restdb.RestWebServiceDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jeevan.model.Aliens;

public class AlienRepository {

	Connection con = null;

	public AlienRepository() {
		String url = "jdbc:mysql://localhost:3306/practice";
		String userName = "root";
		String passWord = "";

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = (Connection) DriverManager.getConnection(url, userName, passWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Aliens> getAliens() {

		List<Aliens> al = new ArrayList<Aliens>();
		String sql = "select * from  aliens";

		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Aliens a = new Aliens();
				a.setName(rs.getString(1));
				a.setId(rs.getInt(2));

				al.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return al;
	}

	public void createAlien(Aliens alien) {

		String sql = "insert into  aliens values (?,?)";

		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, alien.getName());
			st.setInt(2, alien.getId());
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Aliens getAlienById(int id) {
		String sql = "select * from  aliens where id=" + id;
		Aliens a = new Aliens();

		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				a.setName(rs.getString(1));
				a.setId(rs.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;

	}

	public void updateAlien(Aliens alien) {
		
		String sql = "update  aliens set name=? where id=?";

		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, alien.getName());// 1 is because 1st question mark points
			st.setInt(2, alien.getId());//2 is because 2nd question mark points
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteAlienById(int id) {

		String sql = "DELETE FROM aliens WHERE id=" + id;

		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
