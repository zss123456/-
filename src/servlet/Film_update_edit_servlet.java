package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;

import net.sf.json.JSONObject;
import bean.Film_bean;
import services.Film_service;

@WebServlet("/film_update_edit_servlet")
public class Film_update_edit_servlet extends HttpServlet {

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
		String name=request.getParameter("name");
		HttpSession session=request.getSession();
		session.setAttribute("name", name);
		Film_service b=new Film_service();
		Film_bean t=new Film_bean();
		t.setName(name);
		Film_bean c=new Film_bean();
		c=b.fin(t);
		if(c==null){
			out.print("no-ok");
		}
		else{
		JSONObject x=new JSONObject();
		x.put("director", c.getDirector());
		x.put("time", c.getTime());
		x.put("region", c.getRegion());
		x.put("type", c.getType());
		x.put("name", c.getName());
		x.put("language", c.getLanguage());
		x.put("performer", c.getPerformer());
		String url=Base64.encodeBase64String(c.getUrl());
		x.put("url", url);
		out.print(x.toString());
		}
	}
}
