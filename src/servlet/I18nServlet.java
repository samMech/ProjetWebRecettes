package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Utilitaire;

/**
 * Servlet implementation class I18nServlet
 */
@WebServlet("/I18nServlet")
public class I18nServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public I18nServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// R�cup�ration de la session
        HttpSession session = request.getSession();
         
        // R�cup�ration de la langue choisie
        String langueChoisie = request.getParameter("langue");
        
        // On met la langue choisie dans la session
        session.setAttribute("langue", langueChoisie);
        
        // On met � jour le cookie pour le choix de la langue
     	Cookie cookieLangue = Utilitaire.trouverCookie(request.getCookies(), "langue");
 		if(cookieLangue == null){
 			cookieLangue = new Cookie("langue", langueChoisie);
 			cookieLangue.setMaxAge(60*60*24*365);// Expire apr�s 1 ans
 		}
 		else{
 			// Mise � jour du cookie existant
 			cookieLangue.setValue(langueChoisie);
 		}
	 	response.addCookie(cookieLangue);
        	 	
        // Redirection vers la page d'o� la requ�te a �t� envoy�e
	 	response.sendRedirect(request.getHeader("referer")); 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
