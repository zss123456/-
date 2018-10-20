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
import dao.Seat_return_plan_dao;
import bean.Plan_bean;

@WebServlet("/seat_return_plan_servlet")
public class Seat_return_plan_servlet extends HttpServlet {

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
		Plan_bean c=new Plan_bean();
		c.setP_name(name);
		ArrayList<Plan_bean> a=new ArrayList<>();
		Seat_return_plan_dao b=new Seat_return_plan_dao();
		a=b.Seat_Plan(c);
		JSONArray t=new JSONArray();
		for(int i=0;i<a.size();i++){
			JSONObject x=new JSONObject();
			x.put("id", a.get(i).getP_id());
			x.put("name", a.get(i).getP_name());
			x.put("start", a.get(i).getP_start());
			x.put("end", a.get(i).getP_end());
			x.put("time", a.get(i).getP_time());
			t.add(x);
		}
		out.print(t.toString());
	}
}
