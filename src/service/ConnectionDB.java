package service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import objects.Serie;

import java.sql.Connection;

public class ConnectionDB {
	private String user="root";
	private String pass="root123";
	private String url="jdbc:postgresql://localhost:5432/proyectoBD";
	private String classfor="org.postgresql.Driver";
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	public ConnectionDB() {
		
	}
	public Connection getConnection() {
		try {
			Class.forName(classfor);
			con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	public List<Serie> cargaSeries(){
		List<Serie> listSerie = new ArrayList<Serie>();
		String sp ="SELECT * FROM VIEW_SERIES";
		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sp);
			
			while(rs.next()) {
				Serie s = new Serie();
				s.setId(rs.getInt("CVE_SERIE"));
	        	s.setTitulo(rs.getString("TITULO_SERIE"));
	        	s.setDesc(rs.getString("SINOPSIS_SERIE"));
	        	
	        	listSerie.add(s);
			}
			return listSerie;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listSerie;
	}
	public List<Serie> buscaSerie(int i){
		List<Serie> listSerie = new ArrayList<Serie>();
		String sp ="SELECT * FROM VIEW_SERIES WHERE CVE_SERIE = "+i;
		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sp);
			
			while(rs.next()) {
				Serie s = new Serie();
				s.setId(rs.getInt("CVE_SERIE"));
	        	s.setTitulo(rs.getString("TITULO_SERIE"));
	        	s.setDesc(rs.getString("SINOPSIS_SERIE"));
	        	
	        	listSerie.add(s);
			}
			return listSerie;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listSerie;
	}
}
