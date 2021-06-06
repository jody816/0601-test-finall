package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.dev.dto.DTO;
import com.mysql.cj.Session;

public class DAO {
	private static DAO dao = new DAO();
	public DAO() {}
	public static DAO getInstance() {
		return dao;
	}
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment", "root", "2307");
		}catch(Exception e){
			System.out.println("MDAO : connect" + e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.println("Pstmt close error"+e);
			}
		}
		if(conn != null)
		{
			try {
				conn.close();
			}catch(Exception e)
			{
				System.out.println("Conn close error"+e);
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			}catch(Exception e) {
				System.out.println("rs close error" + e);
			}
		}
		close(conn, pstmt);
	}
	public String plogin(String profId, String profPwd) {
		String name = null;
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	conn = connect();
	    	pstmt = conn.prepareStatement("select * from prof where id = ? and pwd = ?;");
			pstmt.setString(1, profId);
			pstmt.setString(2, profPwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
			}
			}catch(Exception e) {
				System.out.println("plogin error" + e);
			}finally {
				close(conn, pstmt, rs);
			}
	    	return name;
	    }
	public String slogin(String id, String pwd) {
		String name = null;
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	conn = connect();
	    	pstmt = conn.prepareStatement("select * from student where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
			}
			}catch(Exception e) {
				System.out.println("slogin error" + e);
			}finally {
				close(conn, pstmt, rs);
			}
	    	return name;
	    }
	
	public void subjectEnrollment(String profId, DTO subject) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?,?,?,?);");
			pstmt.setString(1, subject.getSubjectId());
			pstmt.setString(2, subject.getSubjectName());
			pstmt.setInt(3, subject.getSubjectCount());
			pstmt.setString(4, subject.getProfId());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("MDAO : pSubEnroll" + e);
		}finally {
			close(conn, pstmt);
		}
	}
	public boolean search(String subjectId) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select name from subject where id = ?;");
			pstmt.setString(1, subjectId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				result = true;
			}
		}catch(Exception e)
		{
			System.out.println("search error" + e);
		}finally
		{
			close(conn, pstmt, rs);
		}
		return result;
	}
	public void studentSubjectEnrollment(String id, String subjectId, DTO subject) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into enroll values(?,?);");
			pstmt.setString(1, subjectId);
			pstmt.setString(2, subject.getId());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("MDAO : sSubEnroll" + e);
		}finally {
			close(conn, pstmt);
		}
	}
	
}
