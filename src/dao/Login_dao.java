package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.Login_bean;
import idao.Login_idao;
public class Login_dao implements Login_idao{

	@Override
	public int insert(Login_bean a) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			 conn=dao.Link.getConnection();
			 String sql="insert into login values(?,?,?,?)";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, a.getUsername());
			 ps.setString(2, a.getUserpassword());
			 ps.setString(3, a.getTelephone());
			 ps.setString(4, a.getEmail());
			 n=ps.executeUpdate();
			 if(n==1)
				 return 1;
			 else
				 return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
	}

	@Override
	public int delete(Login_bean b) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			 conn=dao.Link.getConnection();
			 String sql="delete from login where username=?";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, b.getUsername());
			 n=ps.executeUpdate();
			 if(n==1)
				 return 1;
			 else
				 return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
	}

	@Override
	public int update(Login_bean c, String name) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			 conn=dao.Link.getConnection();
			 String sql="update login set username=?,userpassword=?,telephone=?,email=? where username=?";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, c.getUsername());
			 ps.setString(2, c.getUserpassword());
			 ps.setString(3, c.getTelephone());
			 ps.setString(4, c.getEmail());
			 ps.setString(5, name);
			 n=ps.executeUpdate();
			 if(n==1)
				 return 1;
			 else
				 return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
	}

	@Override
	public Login_bean find(Login_bean d) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Login_bean c=new Login_bean();
		c=null;
		try{
			 conn=dao.Link.getConnection();
			 String sql="select * from login where username=?";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, d.getUsername());
			 rs=ps.executeQuery();
			 if(rs.next()){
				c.setUsername(rs.getString(1));
				c.setUserpassword(rs.getString(2));
				c.setTelephone(rs.getString(3));
				c.setEmail(rs.getString(4));
				return c;
			 }
			 else
				 return null;
		}catch(Exception e){
			e.printStackTrace();
            return null;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
	}

	@Override
	public ArrayList<Login_bean> findAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Login_bean> s=new ArrayList<>();
		try{
			 conn=dao.Link.getConnection();
			 String sql="select * from login";
			 ps=conn.prepareStatement(sql);
			 rs=ps.executeQuery();
			 while(rs.next()){
				Login_bean c=new Login_bean();
				c.setUsername(rs.getString(1));
				c.setUserpassword(rs.getString(2));
				c.setTelephone(rs.getString(3));
				c.setEmail(rs.getString(4));
				s.add(c);
			 }
             return s;
		}catch(Exception e){
			e.printStackTrace();
            return null;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
	}

}
