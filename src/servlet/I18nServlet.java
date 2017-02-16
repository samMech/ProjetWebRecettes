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
		
		// Récupération de la session
        HttpSession session = request.getSession();
         		
		// Récupération du cookie pour la langue
		Cookie cookieLangue = Utilitaire.trouverCookie(request.getCookies(), "langue");
		if(cookieLangue == null){
 			cookieLangue = new Cookie("langue", request.getLocale().getLanguage());
 		}
		
		// Renouvellement du cookie
		cookieLangue.setMaxAge(60*60*24*365);// Expire après 1 ans
		
		// Récupération de la langue choisie
        String langueChoisie = request.getParameter("langue");
        if(langueChoisie != null && langueChoisie.isEmpty() == false){
        	cookieLangue.setValue(langueChoisie);
        }        

 		// On renvoie le cookie mis à jour avec la réponse
	 	response.addCookie(cookieLangue);
	 	
        // On met la langue dans la session
        session.setAttribute("langue", cookieLangue.getValue());
                	 	
        // Redirection vers la page d'où la requête a été envoyée
	 	response.sendRedirect(request.getHeader("referer")); 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
