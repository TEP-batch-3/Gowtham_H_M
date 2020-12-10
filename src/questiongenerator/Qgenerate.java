package questiongenerator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.iquest.action.*;
import com.tcs.ilp.iquest.bean.Question;
/**
 * Servlet implementation class Qgenerate
 */
@WebServlet("/Qgenerate")
public class Qgenerate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qgenerate() {
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
		Question que =new Question();
		Qgenaratebean qb = new Qgenaratebean();
		UserBean ub = new UserBean();
	String	noq = request.getParameter("noq");
	int noOfQuestions=Integer.parseInt(noq);
	qb.setNoOfQuestions(noOfQuestions);
//	System.out.println("Qgenerator  "+noOfQuestions);
	ExternalQuestionService eqg = new ExternalQuestionService();
	try {
		String empid = ub.getEmpid();
		System.out.println("qgenerate get"+empid);
		if(empid==null)
		{
			System.out.println("empid is null");
		}
		else {
			eqg.generateQuestion(empid, "1");	
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	System.out.println(noOfQuestions);
	
	response.sendRedirect("userLogged.jsp");
	}

}
