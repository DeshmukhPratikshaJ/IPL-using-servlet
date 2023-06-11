package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoClass;
import dao.TeamDaoClass;

@WebServlet(value="/AddPlayer",loadOnStartup =1)
public class RegPlayer extends HttpServlet {

	PlayerDaoClass playerDao;
	TeamDaoClass teamDao;

	public void init(ServletConfig config) throws ServletException {
		try {
			playerDao = new PlayerDaoClass();
			teamDao = new TeamDaoClass();
			System.out.println("player init");
		} catch (SQLException e) {
			throw new ServletException("err in player init:", e);
		}

	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		session.setAttribute("action", "adding player");
		session.setAttribute("dao_p", playerDao);
		session.setAttribute("dao_t", teamDao);
		
		try(PrintWriter pw=resp.getWriter()){
			pw.print("<h1>Registering new player</h1><br/>");
			pw.print("<form action='registeredPorT' method='GET'><table border='2px'>");
			
			pw.print("<tr><td>team name</td><td>");
			pw.print("<select id='team' name='team'>"); 
			for(String t:teamDao.getTeamNames()) {
				System.out.println(t);
			pw.print("<option name='team' id="+t+"value="+t+"/>");
			}
			pw.print("</select></td></tr>");
			pw.write("<tr><td>name</td><td><input type='text' name='nm' id='nm' required></td></tr>");
			pw.write("<tr><td>DOB</td><td><input type='date' name='dob' id='dob' required></td></tr>");
			pw.write("<tr><td>batting avg</td><td><input type='text' name='ba' id='ba' required></td></tr>");
			pw.write("<tr><td>wicket per match</td><td><input type='text' name='wpm' id='wpm' required></td></tr></table>");
			pw.print("<input type='submit' value='register player'/>");
			pw.print("</form>");
			
		} catch (SQLException e) {
			throw new ServletException("err in doGet reg player:"+e);
		}
	}

	public void destroy() {
		try {
			playerDao.cleanup();
			teamDao.cleanup();
		} catch (SQLException e) {
			System.out.println("err in destroy register player");
		}
	}
}