package servlet;
import services.Theatre_service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import bean.Theatre_bean;
import dao.Theatre_dao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

@WebServlet("/theatre_update_servlet_edit")
public class Theatre_update_servlet_edit extends HttpServlet {

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
		int n=0;
		HttpSession session=request.getSession();
		String id=request.getParameter("id");
		int T_id=Integer.parseInt(id==null||"".equals(id)?"0":id);
		session.setAttribute("id", T_id);
		Theatre_service a=new Theatre_service();
		Theatre_bean g=new Theatre_bean();
		g.setId(T_id);
		Theatre_bean b=new Theatre_bean();
		try {
			b=a.fin(g);
			if(b!=null){
			JSONObject json=new JSONObject();
			json.put("id", b.getId());
			json.put("name", b.getName());
			json.put("rows", b.getRows());
			json.put("cols", b.getCols());
			json.put("desc", b.getDesc());
			out.print(json.toString());
			}
			else
				out.print("no-ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
