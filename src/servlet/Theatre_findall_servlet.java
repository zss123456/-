package servlet;
import services.Theatre_service;



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
import bean.Theatre_bean;

@WebServlet("/theatre_findall_servlet")
public class Theatre_findall_servlet extends HttpServlet {

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
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		Theatre_service a=new Theatre_service();
		ArrayList<Theatre_bean> c=new ArrayList<>();
		try {
			c=(ArrayList<Theatre_bean>)a.all().clone();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONArray jsonArray=new JSONArray();
		try {
			
			for(int i=0;i<c.size();i++){
				JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", c.get(i).getId());
			jsonObject.put("name", c.get(i).getName());
			jsonObject.put("rows", c.get(i).getRows());
			jsonObject.put("cols", c.get(i).getCols());
			jsonObject.put("desc", c.get(i).getDesc());
			jsonArray.add(jsonObject);
			}
                 out.print(jsonArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
