package filte;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class Login_filter
 */
@WebFilter(filterName="/FilterIP",urlPatterns={"/main-interface.html","/film.html","/movie_hall.html"})
public class Login_filter implements Filter {

    /**
     * Default constructor. 
     */
    public Login_filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest Request=(HttpServletRequest)request;
		HttpSession session=Request.getSession(true);
		String a=(String)session.getAttribute("user");
		if(a==null)
		{
		    Request.getRequestDispatcher("/login_error.jsp").forward(request, response);}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
