package dao;
import java.sql.*;
import java.util.ArrayList;
import bean.Seat_bean;
public class Seat_return_state_dao {
	public ArrayList<Seat_bean> Seat_state(int id,String start){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Seat_bean> a=new ArrayList<>();
		try{
			conn=dao.Link.getConnection();
			String sql="select * from seat where S_id=? and S_start=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, start);
			rs=ps.executeQuery();
			while(rs.next()){
				Seat_bean x=new Seat_bean();
				x.setS_id(rs.getInt(1));
				x.setS_number(rs.getString(2));
				x.setS_state(rs.getString(3));
				x.setS_time(rs.getString(4));
				x.setS_start(rs.getString(5));
				a.add(x);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		return a;
	}
}
