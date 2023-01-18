package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.sbi;
import com.util.DButil;


/*
package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Book;
import com.util.DBUtil;


*/

public class BankDalImplement implements BankDal {

	private Connection con;
	private Statement smt;
	private ResultSet rset;
	private PreparedStatement psmt;
	private PreparedStatement psmt1;
	private PreparedStatement psmt2;
	

	public BankDalImplement() throws SQLException {
		con = DButil.getCon();
		psmt= con.prepareStatement(" insert into sbi value(?,?,?,?)");
		psmt1 = con.prepareStatement("delete from sbi where acctnum =?");
		psmt2 = con.prepareStatement("update sbi set balance=?,name=?,location=? where acctnum=?");
		
	}

	@Override
	public List<sbi> showallaccount() throws SQLException {
		System.out.println("Inside DAL");
		smt=con.createStatement();
		// TODO Auto-generated method stub
		int count=0;
		/*
		 * 	private int acctnum;
	private double balance;
	private String name;
	private String location;
		 * */
		try {
			List<sbi> blist=new ArrayList<sbi>();
		
			rset= smt.executeQuery("select * from sbi");
			while(rset.next())
			{
			
				blist.add(new sbi(rset.getInt("acctnum"),
						rset.getDouble("balance"),
						rset.getString("name"), 
						rset.getString("location")));
			count++;
			
			}
			
			return blist;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally {
		System.out.println("Query are affected:"+count);
	}
		return null;
		
	}

	@Override
	public int insertaccount(sbi sobj)  {
		try {
			psmt.setInt(1, sobj.getAcctnum());
			psmt.setDouble(2, sobj.getBalance());
			psmt.setString(3, sobj.getName());
			psmt.setString(4, sobj.getLocation());
			int i = psmt.executeUpdate();
			
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteaccount(int id) {
		try {
			psmt1.setInt(1, id);
			int i = psmt1.executeUpdate();
			return i;
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateaccount(int id, sbi sobj) {
		try {
			psmt2.setDouble(1, sobj.getBalance());
			psmt2.setString(2, sobj.getName());
			psmt2.setString(3, sobj.getLocation());
			psmt2.setInt(4, id);
			int i = psmt2.executeUpdate();
			return i;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
