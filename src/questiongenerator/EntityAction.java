package questiongenerator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/EntityAction")
public class EntityAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntityAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ActionDAO adao = new ActionDAO();
		ActionBean ab = new ActionBean();
		ab.setentity_title(request.getParameter("ET"));
		ab.setentity_usage(request.getParameter("US"));
		if(request.getParameter("ET").isEmpty()&&request.getParameter("US").isEmpty()) {
			System.out.println("Entity Fields are empty");
		}
		else {
			System.out.println(adao.addEntity());
			response.sendRedirect("adminLogged.jsp");
		}
	}

}
