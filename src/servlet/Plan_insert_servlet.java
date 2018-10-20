package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.Plan_service;
import bean.Plan_bean;

@WebServlet("/plan_insert_servlet")
public class Plan_insert_servlet extends HttpServlet {

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
		String iid=request.getParameter("id");
		int id=Integer.parseInt(iid==null||"".equals(iid)?"0":iid);
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String time=request.getParameter("time");
		Plan_bean a=new Plan_bean();
		a.setP_end(end);
		a.setP_id(id);
		a.setP_name(name);
		a.setP_start(start);
		a.setP_time(time);
		Plan_service c=new Plan_service();
	    int n=0;
	    n=c.add(a);
	    if(n==1)
	    	out.print("ok");
	    else if(n==2)
	    	out.print("nok");
	    else
	    	out.print("no-ok");
	    
	}
}
