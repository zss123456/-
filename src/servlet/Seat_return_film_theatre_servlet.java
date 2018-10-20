package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import dao.Seat_return_state_dao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import services.Film_service;
import services.Theatre_service;
import bean.Film_bean;
import bean.Seat_bean;
import bean.Theatre_bean;

@WebServlet("/seat_return_film_theatre_servlet")
public class Seat_return_film_theatre_servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//对于get请求的乱码解决，先采用iso8859-1编码，再使用utf-8解码
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//对于post请求，设置请求编码，防止乱码
		request.setCharacterEncoding("utf-8");
		//设置响应正文的编码和浏览器解码采用的编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String start=request.getParameter("start");
		int T_id=Integer.parseInt(id==null||"".equals(id)?"0":id);
		Theatre_bean g=new Theatre_bean();
		g.setId(T_id);
		Theatre_bean u=new Theatre_bean();
		Theatre_service h=new Theatre_service();
		try {
			u=h.fin(g);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject r=new JSONObject();
		r.put("rows", u.getRows());
		r.put("cols", u.getCols());
		String name=request.getParameter("name");
		Film_bean a=new Film_bean();
		a.setName(name);
		Film_service b=new Film_service();
		Film_bean c=new Film_bean();
		c=b.fin(a);
		String url=Base64.encodeBase64String(c.getUrl());
		JSONObject x=new JSONObject();
      	 x.put("director", c.getDirector());
     	 x.put("name", c.getName());
    	 x.put("type", c.getType());
   	     x.put("time", c.getTime());
     	 x.put("performer", c.getPerformer());
    	 x.put("region", c.getRegion());
    	 x.put("language", c.getLanguage());
   	     x.put("url", url);
   	    ArrayList<Seat_bean> p=new ArrayList<>();
   	    Seat_return_state_dao o=new Seat_return_state_dao();
   	    p=o.Seat_state(T_id, start);
   	    int q;
   	    JSONArray y=new JSONArray();
   	    for(q=0;q<p.size();q++){
   	    	JSONObject l=new JSONObject();
   	    	l.put("number", p.get(q).getS_number());
   	    	l.put("state", p.get(q).getS_state());
   	    	y.add(l);
   	    }
   	     out.print(r.toString()+"#"+x.toString()+"#"+y.toString());
	}
}
