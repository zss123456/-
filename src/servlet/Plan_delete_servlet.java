package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Plan_service;
import bean.Plan_bean;

@WebServlet("/plan_delete_servlet")
public class Plan_delete_servlet extends HttpServlet {

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
		String iid=request.getParameter("id");
		int id=Integer.parseInt(iid==null||"".equals(iid)?"0":iid);
		String time=request.getParameter("start");
		Plan_bean a=new Plan_bean();
		a.setP_id(id);
		a.setP_start(time);
	    Plan_service b=new Plan_service();
	    int n=0;
	    n=b.del(a);
	    if(n==1)
	    	out.print("ok");
	    else
	    	out.print("no-ok");
	}
}
