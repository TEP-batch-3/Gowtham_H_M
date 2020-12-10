package questiongenerator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConceptAction
 */
@WebServlet("/ConceptAction")
public class ConceptAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConceptAction() {
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
		ab.setconcept_title(request.getParameter("CT"));
		String ct = request.getParameter("CT");
		String csd = request.getParameter("CSD");
		if(csd.equals("True")) {
			ab.setconcept_scenario_driven(true);
		}
		else {
			ab.setconcept_scenario_driven(false);
			}
		String ced = request.getParameter("CED");
		if(ced.equals("True")) {
			ab.setconcept_enetiy_driven(true);
		}	else {	ab.setconcept_enetiy_driven(false);}
		String cod = request.getParameter("COD");
		System.out.println(cod);
		if(cod.equals("True")) {
			ab.setconcept_operation_driven(true);
		}	else {ab.setconcept_operation_driven(false);}
	
	if(ct.isEmpty()&&csd.isEmpty()&&ced.isEmpty()&&cod.isEmpty()) {
			System.out.println("Concept Fields are empty");
	}
		else {
			System.out.println(adao.addConcept());
			response.sendRedirect("adminLogged.jsp");
		}
	}

}
