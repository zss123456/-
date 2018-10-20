package dao; 
import java.util.ArrayList;
import bean.Theatre_bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import dao.Link;
import idao.Theatre_idao;
public class Theatre_dao implements Theatre_idao{

	@Override
	public int insert(Theatre_bean a) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n = 0;
		try{
			conn=dao.Link.getConnection();
			String sql="insert into theatre values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, a.getId());
			ps.setString(2, a.getName());
			ps.setInt(3, a.getRows());
			ps.setInt(4, a.getCols());
			ps.setString(5, a.getDesc());
			n=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		if(n==1)
		return 1;
		else
		return 0;
	}

	@Override
	public int delete(Theatre_bean b) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			conn=dao.Link.getConnection();
			String sql="delete from theatre where T_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, b.getId());
			n=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		if(n==1)
			return 1;
			else
			return 0;
	}

	@Override
	public int update(Theatre_bean c,int id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			conn=dao.Link.getConnection();
			String sql="update theatre set T_id=?,T_name=?,T_rows=?,T_cols=?,T_desc=? where T_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getName());
			ps.setInt(3, c.getRows());
			ps.setInt(4, c.getCols());
			ps.setString(5, c.getDesc());
			ps.setInt(6, id);
			n=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			dao.Link.free(rs, ps, conn);
		}
		if(n==1)
			return 1;
			else
			return 0;
	}

	@Override
	public Theatre_bean find(Theatre_bean d) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Theatre_bean q=new Theatre_bean();
		try{
			conn=dao.Link.getConnection();
			String sql="select * from theatre where T_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, d.getId());
			rs=ps.executeQuery();
			if(rs.next()){
			q.setId(rs.getInt(1));
			q.setName(rs.getString(2));
			q.setRows(rs.getInt(3));
			q.setCols(rs.getInt(4));
			q.setDesc(rs.getString(5));
			return q;
			}
			else
				return null;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		return null;
		
	}

	@Override
	public ArrayList<Theatre_bean> findAll() throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Theatre_bean> c=new ArrayList<>();
		try{
			conn=dao.Link.getConnection();
			String sql="select * from theatre";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Theatre_bean stu=new Theatre_bean();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setRows(rs.getInt(3));
				stu.setCols(rs.getInt(4));
				stu.setDesc(rs.getString(5));
				c.add(stu);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		     dao.Link.free(rs, ps, conn);	
		}
	               
		return c;
	}


}
