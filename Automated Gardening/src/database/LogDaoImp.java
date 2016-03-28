package database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gardenController.Gardencontroller;

public class LogDaoImp implements LogDao {

	

	@Override
	public Log addLog(Log log) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;

		String sql = "insert into log values(" + log.getDayofevent() + "," + "'" + log.getTimeofevent() + "'" + ","
				+ "'" + log.getTypeofevent() + "'" + "," + "'" + log.getAction() + "'" + "," + log.getGrid() + ")";
	

		try {
			DataStore ds = new DataStore();
			con = ds.createConnection("jdbc:mysql://localhost:3306/gardening?autoReconnect=true&useSSL=false", Gardencontroller.username,
					Gardencontroller.Password);
			

			st = con.prepareStatement(sql);
			st.executeUpdate(sql);

			// System.out.println("database updated");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return log;
	}

	@Override
	public List<Log> getAllLogs(String path) {

		List log = new ArrayList();
		Connection con = null;

		try {

			DataStore ds = new DataStore();
			con = ds.createConnection("jdbc:mysql://localhost:3306/gardening?autoReconnect=true&useSSL=false", Gardencontroller.username,
					Gardencontroller.Password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from log");

			while (rs.next()) {
				String dayofevent = rs.getString("dayofevent");
				String timeofevent = rs.getString("timeofevent");
				String typeofevent = rs.getString("typeofevent");
				String action = rs.getString("action");
				String grid = rs.getString("grid");
				log.add(dayofevent + "," + timeofevent + ", " + typeofevent + ","+ action + ","+ grid);

			}
			copyToFile(log, path);
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return log;
	}

	public List<Log> getLogs(String path, int day) {

		List log = new ArrayList();
		Connection con = null;

		try {

			DataStore ds = new DataStore();
			con = ds.createConnection("jdbc:mysql://localhost:3306/gardening?autoReconnect=true&useSSL=false", Gardencontroller.username,
					Gardencontroller.Password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from log where dayofevent= 1");

			while (rs.next()) {
				String dayofevent = rs.getString("dayofevent");
				String timeofevent = rs.getString("timeofevent");
				String typeofevent = rs.getString("typeofevent");
				String action = rs.getString("action");
				String grid = rs.getString("grid");
				log.add(dayofevent + "," + timeofevent + "," + typeofevent + "," + action + "," + grid);

			}
			copyToFile(log, path);
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return log;
	}

	public void deleteLogs() {

		Connection con = null;

		try {

			DataStore ds = new DataStore();
			con = ds.createConnection("jdbc:mysql://localhost:3306/gardening?autoReconnect=true&useSSL=false", Gardencontroller.username,
					Gardencontroller.Password);
			Statement st = con.createStatement();
			int deleted = st.executeUpdate("DELETE FROM log");

			st.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		// return log;
	}

	private static void copyToFile(List list, String path) {
		BufferedWriter out = null;
		try {
			File file = new File(path);
			if (file.exists()) {
				file.createNewFile();
			}
			out = new BufferedWriter(new FileWriter(file, true));
			out.write("dayofevent," + "time hr:mm:ss," + "typeofevent," + "action," + "grid");
			out.newLine();
			for (Object s : list) {
				out.write((String) s);
				out.newLine();

			}
			out.close();
		} catch (IOException e) {
		}

	}

}
