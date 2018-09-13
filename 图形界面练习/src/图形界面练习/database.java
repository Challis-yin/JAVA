package 图形界面练习;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class database {
	
	static String url ="jdbc:mysql://localhost:3306/miniqq?useUnicode=true"
			+ "&characterEncoding=utf-8&useSSL=false";
	Connection c;
	static String N = "root";
	static String C = "yinchenglin";
	
	int name = 0;String code = null;
	boolean trust = false;
	public static void main(String[] arg) throws SQLException{
//		Driver driver = new com.mysql.jdbc.Driver();
//		String url ="jdbc:mysql://localhost:3306/miniqq?useUnicode=true"
//				+ "&characterEncoding=utf-8&useSSL=false";
//		Connection c;
//		c= DriverManager.getConnection(url,N,C);
//		if(!c.isClosed())
//			System.out.println("数据库连接成功！！");
//		Statement st = c.createStatement();
//		String sql = "select*from user";
//		ResultSet rs = st.executeQuery(sql);
//		int name = 0;String code = null;
//		while(rs.next()) {
//			name = rs.getInt("name");
//			code = rs.getString("code");
//			System.out.println(name+"\t"+code);
//		}
		System.out.println(getcount());
		String[] kkk = getnickname();
		for(int i = 0;i<4;i++)
			System.out.println(kkk[i]);
	}
	public boolean trys(int name1,String code1) throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();
		String url ="jdbc:mysql://localhost:3306/miniqq?useUnicode=true"
				+ "&characterEncoding=utf-8&useSSL=false";
		Connection c;
		c= DriverManager.getConnection(url,N,C);
//		if(!c.isClosed())
//			System.out.println("数据库连接成功！！");
		Statement st = c.createStatement();
		String sql = "select*from user";
		ResultSet rs = st.executeQuery(sql);
		int name = 0;String code = null;
		while(rs.next()) {
			if(rs.getInt("name")==name1&&rs.getString("code").equals(code1)) {
				c.close();
				return true;
			}
		}
		c.close();
		return false;
	}
	public void add(int name1,String code1,String nicheng) throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();
		Connection c;
		c= DriverManager.getConnection(url,N,C);
		PreparedStatement psql = (PreparedStatement) c.prepareStatement("insert into user (name,code,nicheng)"+"values(?,?,?)");  //用preparedStatement预处理来执行sql语句
        psql.setInt(1, name1);  //给其五个参量分别“赋值”
        psql.setString(2, code1);
        psql.setString(3, nicheng);
        psql.executeUpdate();  //参数准备后执行语句
		System.out.println("SUCCESS");
		c.close();
	}
	public void tonew(int name1,String code1) throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();
		Connection c;
		c= DriverManager.getConnection(url,N,C);
		Statement st = c.createStatement();
		String sql = "select*from user";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			if(rs.getInt("name")==name1) {
				PreparedStatement psql;
	            psql = (PreparedStatement) c.prepareStatement("update user set code = ? where name = ?");
				psql.setString(1, code1);
				psql.setInt(2, name1);
				psql.executeUpdate();
	            
			}
		}c.close();	
	}
	public static int getcount() throws SQLException {
				int count=0;
				try {
		Driver driver = new com.mysql.jdbc.Driver();
		Connection c;
		c= DriverManager.getConnection(url,N,C);
		Statement st = c.createStatement();
		String sql = "select*from user";
		ResultSet rs =st.executeQuery(sql);  
		//创建变量存取个数  
  
		while(rs.next())  
		{  
		count++;  
		}  c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
		return count;
		}
	}
	public static String[] getnickname() throws SQLException {
		String[] nick = new String[getcount()];
		Driver driver = new com.mysql.jdbc.Driver();
		Connection c;
		c= DriverManager.getConnection(url,N,C);
		Statement st = c.createStatement();
		String sql = "select*from user";
		ResultSet rs =st.executeQuery(sql);  
		//创建变量存取个数  
        int i = 0;
		while(rs.next())  
		{  
		
		nick[i] = rs.getString("nicheng");
		i++;
		}  
		c.close();
		return nick;
	}
	public void addq(String str) throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();
		Connection c;
		c= DriverManager.getConnection(url,N,C);
		PreparedStatement psql = (PreparedStatement) c.prepareStatement("insert into qunliao (id)"+"values(?)");  //用preparedStatement预处理来执行sql语句
        psql.setString(1,str);
        psql.executeUpdate();  //参数准备后执行语句
		System.out.println("SUCCESS");
		c.close();
	}
	public boolean trys2(String str) throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();
		String url ="jdbc:mysql://localhost:3306/miniqq?useUnicode=true"
				+ "&characterEncoding=utf-8&useSSL=false";
		Connection c;
		c= DriverManager.getConnection(url,N,C);
//		if(!c.isClosed())
//			System.out.println("数据库连接成功！！");
		Statement st = c.createStatement();
		String sql = "select*from qunliao";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			if(rs.getString("id").equals(str)) {
				c.close();
				return true;
			}
		}
		c.close();
		return false;
	}
		
	
}
	
	
	
	
	
	

