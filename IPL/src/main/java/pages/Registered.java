package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoClass;
import dao.TeamDaoClass;

@WebServlet("/registeredPorT")
public class Registered extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("txt/html");
		HttpSession hs = request.getSession();
		// System.out.println(hs);
		try (PrintWriter pw = response.getWriter()) {
			if (hs != null) // not new session
			{
				String act = (String) hs.getAttribute("action");
				PlayerDaoClass daoP = (PlayerDaoClass) hs.getAttribute("dao_p");
				TeamDaoClass daoT = (TeamDaoClass) hs.getAttribute("dao_t");
				if(act.equals("adding player")) {
					String team=request.getParameter("team");
					String name=request.getParameter("nm");
					Date dob=Date.valueOf(request.getParameter("dob"));
					double ba=Double.parseDouble(request.getParameter("ba"));
					double wpm=Double.parseDouble(request.getParameter("wpm"));
					LocalDate today=LocalDate.now();
					
					System.out.println(Period.between(dob.toLocalDate(),today));
					
					try {
						String msg=daoP.addNewP(name, dob, ba, wpm, team);
						pw.write(msg);
					} catch (SQLException e) {
						throw new ServletException("err in do get while adding player",e);
					}
				}
				else {
					//add team
				}
			
				pw.write("<h3><a href='display'>show all teams and players</a></h3>");
			} else {
				pw.print("<h5>registration failed</h5><a href='IPLhome.html'>add  again</a>");
			}
		}
	}

}
