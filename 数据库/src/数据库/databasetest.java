package 数据库;
import java.sql.*;

public class databasetest {
	public static void main(String[] arg) throws SQLException{
		Driver driver = new com.mysql.jdbc.Driver();
		String url ="jdbc:mysql://localhost:3306/miniqq?useUnicode=true"
				+ "&characterEncoding=utf-8&useSSL=false";
		Connection c;
		c= DriverManager.getConnection(url,"root","123456");
		if(!c.isClosed())
			System.out.println("数据库连接成功！！");
		Statement st = c.createStatement();
		String sql = "select*from user";
		ResultSet rs = st.executeQuery(sql);
		int name = 0;String code = null;
		while(rs.next()) {
			name = rs.getInt("name");
			code = rs.getString("code");
			System.out.println(name+"\t"+code);
		}
	}
}
