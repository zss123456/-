package dao;
import java.util.Properties;
import java.sql.*;
import java.io.*;
public final class Link {
          private static String driver;
          private static String url;
          private static String user;
          private static String password;
          private static Properties pr=new Properties();
          static{
                     try {
						pr.load(Link.class.getClassLoader().getResourceAsStream("database.properties"));
						driver=pr.getProperty("driver");
						url=pr.getProperty("url");
						user=pr.getProperty("username");
						password=pr.getProperty("userpassword");
						Class.forName(driver);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}      	  
          }
          public static Connection getConnection() throws SQLException{
        	  return DriverManager.getConnection(url,user,password);
          }
          public static void free(ResultSet rs,Statement ps,Connection conn){
        	  try{
        		  if(rs!=null)
        			  rs.close();
        	  }catch(Exception e){
        		  e.printStackTrace();
          }finally{
        	  try{
        		  if(ps!=null)
        			  ps.close();
        	  }catch(Exception e){
        		  e.printStackTrace();
        	  }finally{
        		  if(conn!=null)
        			  try{
        				  conn.close();
        			  }catch(Exception e){
        				  e.printStackTrace();
        			  }
        	  }
          }
}
}