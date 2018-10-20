package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import services.Plan_service;
import bean.Plan_to_bean;
import bean.Plan_too_bean;

@WebServlet("/Plan_return_servlet")
public class Plan_return_servlet extends HttpServlet {

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
		ArrayList<Plan_to_bean> a=new ArrayList<>();
		ArrayList<Plan_too_bean> c=new ArrayList<>();
	 	Plan_service b=new Plan_service();
	 	a=b.to();
	 	c=b.too();
	 	PrintWriter out=response.getWriter();
	 	int i=0;
	 	int r=0;
	 	JSONArray y=new JSONArray();
	 	for(i=0;i<a.size();i++){
	 		JSONObject t=new JSONObject();
	 		t.put("name", a.get(i).getF_name());
	 		t.put("time", a.get(i).getF_time());
	 		y.add(t);
	 	}
	 	JSONArray u=new JSONArray();
	 	for(r=0;r<c.size();r++){
	 		JSONObject e=new JSONObject();
	 		e.put("id", c.get(r).getT_id());
	 		u.add(e);
	 	}
	 	out.print(y.toString()+"#"+u.toString());
	}
}