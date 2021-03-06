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
        if(session == null){
			response.sendRedirect("accueil.jsp");
			return;
		} 	
        
		// R�cup�ration du cookie pour la langue
		Cookie cookieLangue = Utilitaire.trouverCookie(request.getCookies(), "langue");
		if(cookieLangue == null){
 			cookieLangue = new Cookie("langue", request.getLocale().getLanguage());
 		}
		
		// Renouvellement du cookie
		cookieLangue.setMaxAge(60*60*24*365);// Expire apr�s 1 ans
		
		// R�cup�ration de la langue choisie
        String langueChoisie = request.getParameter("langue");
        if(langueChoisie != null && langueChoisie.isEmpty() == false){
        	cookieLangue.setValue(langueChoisie);
        }        

 		// On renvoie le cookie mis � jour avec la r�ponse
	 	response.addCookie(cookieLangue);
	 	
        // On met la langue dans la session
        session.setAttribute("langue", cookieLangue.getValue());
        
        // Redirection vers la page d'o� la requ�te a �t� envoy�e (ou la page d'accueil si null)
        String pageSource = request.getHeader("referer");
	 	if(pageSource != null){
	 		response.sendRedirect(pageSource);
	 	}
	 	else{
	 		response.sendRedirect("accueil.jsp");
	 	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
