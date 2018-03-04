package controleurs;

import accesBDD.LigneCommandeDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import obj.Commande;
import obj.Evenement;
import obj.LigneCommande;
import obj.Livres;
import obj.Pays;
import traitements.GestionCommandes;
import traitements.GestionEvenement;
import traitements.GestionLivres;
import traitements.GestionLogin;
import traitements.GestionPays;

@WebServlet(name = "ControllerMain", urlPatterns = {"/ControllerMain"})
public class ControllerMain extends HttpServlet {
    
    private Cookie getCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String saisie = null;
        request.setAttribute("path", "/LibrairieFusion-v1.0/img/");
        String pageJSP = "/WEB-INF/jspMain.jsp";
        String section = request.getParameter("section");
        ArrayList<String> compteur = new ArrayList<>();
        compteur.add("1");
        compteur.add("2");
        compteur.add("3");
        request.setAttribute("compteur", compteur);
        
        
        
        
        if ("menu-main".equals(section)) {
            pageJSP = "/WEB-INF/menus/menu-main.jsp";
        }
        if ("home".equals(section)) {
            pageJSP = "/WEB-INF/home.jsp";
        }
        if ("catalogue".equals(section)) {
            try {
                pageJSP = "/WEB-INF/catalogue.jsp";
                GestionLivres maGestionLivre = new GestionLivres();
                ArrayList<Livres> mesLivres = maGestionLivre.findLivres(false, saisie);

                request.setAttribute("maListeLivres", mesLivres);
                for (Livres monLivre : mesLivres) {
                    monLivre.getResumeLivre().substring(0, monLivre.getResumeLivre().length() / 3);
                }
            } catch (NamingException | SQLException ex) {
                ex.printStackTrace();
            }
        }

        if ("Evenement".equals(section)) {
            try {
                pageJSP = "/WEB-INF/Evenement.jsp";
                GestionEvenement maGestionEvenement = new GestionEvenement();
                ArrayList<Evenement> mesEvenements = maGestionEvenement.findEvenement(false, saisie);

                ArrayList<String> s = new ArrayList<>();
                for (Evenement mesEvenement : mesEvenements) {
                    s.add(mesEvenement.toString());

                    session.setAttribute("mesEvenements", s);
                }
              
        
                System.out.println(s);

            } catch (NamingException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
          if("RechercheEvenement".equals(section)){
             try {
            pageJSP = "/WEB-INF/Evenement.jsp";
                GestionEvenement maGestionEvenement = new GestionEvenement();
                ArrayList<Evenement> mesEvenements = maGestionEvenement.findEvenement(true, request.getParameter("rechercheEvenement"));

                ArrayList<String> s = new ArrayList<>();
                for (Evenement mesEvenement : mesEvenements) {
                    s.add(mesEvenement.toString());

                    session.setAttribute("mesEvenements", s);
                }
                System.out.println(s);

            } catch (NamingException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if ("Recherche".equals(section)) {
            try {
//                pageJSP = "/WEB-INF/recherche.jsp";
                pageJSP = "/WEB-INF/catalogue.jsp";
                GestionLivres maGestionLivre = new GestionLivres();

//                ArrayList<Livres> mesResultats = maGestionLivre.findLivresbysearch(request.getParameter("recherche"));
                ArrayList<Livres> mesLivres = maGestionLivre.findLivres(true, request.getParameter("recherche"));
//                session.setAttribute("mesResultats", mesResultats);
                request.setAttribute("maListeLivres", mesLivres);

            } catch (NamingException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
                //
            }
        }
        
//=====================COMMANDES================================================        
        if ("order".equals(section)) {
            System.out.println("hello");
            try {
                pageJSP = "/WEB-INF/order.jsp";
                GestionCommandes gestionC = new GestionCommandes();
                List<Commande> com = gestionC.findOrder();
                request.setAttribute("gestionC", com);
            } catch (NamingException | SQLException ex) {
                ex.printStackTrace();
            }
        }


        if ("orderLine".equals(section)) {
            System.out.println("hello");
            try {
                pageJSP = "/WEB-INF/orderLine.jsp";
                LigneCommandeDAO gestionLC = new LigneCommandeDAO();
                List<LigneCommande> lcom = gestionLC.selectAllOrderLineByOrder();
                for(LigneCommande ldc : lcom){
                    System.out.println(ldc.getIDLigneCommande());
                }
                request.setAttribute("gestionLC", lcom);
                

            } catch (NamingException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        /////////////////////////////////LOGIN//////////////////////////////////////////////////////////
         
        
        if (getServletContext().getAttribute("GestionLogin") == null) {
            try {
                getServletContext().setAttribute("GestionLogin", new GestionLogin());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        GestionLogin bLogin = (GestionLogin) getServletContext().getAttribute("GestionLogin");
		Cookie c = getCookie(request.getCookies(), "login");
                if (c != null) {
                    pageJSP = "/WEB-INF/jspWelcome.jsp";
                    request.setAttribute("welcome", c.getValue());
                }
                if (request.getParameter("deconnect") != null) {
                    System.out.println("deconnection");
                    pageJSP = "/WEB-INF/jspLogin.jsp";
//                    request.setAttribute("login", c.getValue());
                    Cookie cc = new Cookie("login", "");
                    cc.setMaxAge(0);
                    response.addCookie(cc);
                }
                c = getCookie(request.getCookies(), "try");
                if (c != null) {
                    if (c.getValue().length() >= 3) {
                        pageJSP = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", "Trop de tentatives !!!!!");
                    }
                }
		
		if ("login".equals(section)) {
            pageJSP = "/WEB-INF/jspLogin.jsp";
            if (request.getParameter("doIt") != null ) {         
                if (bLogin.check(request.getParameter("login"), request.getParameter("password"))) {
                    System.out.println("conexion reussi");
                    pageJSP = "/WEB-INF/jspWelcome.jsp";
                    String login = request.getParameter("login");
                    request.setAttribute("welcome", login);
                     c = new Cookie("login", login);
                    c.setMaxAge(60);
                    c.setPath("/");
                    response.addCookie(c);
                    Cookie c2 = new Cookie("try", "");
                    c2.setMaxAge(0);
                    response.addCookie(c2);
                    
                } else {
                    pageJSP = "/WEB-INF/jspLogin.jsp";
                    request.setAttribute("login", request.getParameter("login"));
                    request.setAttribute("msg", "Erreur login/Mot de passe !!!");
                     c = getCookie(request.getCookies(), "try");
                    if (c == null) {
                        c = new Cookie("try", "*");
                        System.out.println("nouveau cookie essai"+ c );
                    } else {
                        System.out.println("cookie existant"+ c);
                        c.setValue(c.getValue() + "*");
                    }
                    c.setMaxAge(90);
                    System.out.println(c.getValue());
                    response.addCookie(c);
                    
                    if (c.getValue().length() >= 3) {
                        pageJSP = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", "Trop de tentatives !!!");
                    }
                }
                
                
                
            }
        }/////////////////////////////////
        if (getServletContext().getAttribute("gestionPays") == null) {
            try {
                getServletContext().setAttribute("gestionPays", new GestionPays());
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
        GestionPays gestionPays = (GestionPays) getServletContext().getAttribute("gestionPays");

        if ("afficher-pays".equals(section)) {
            try {
                HashMap<String, List<Pays>> mp = gestionPays.findPays();
                List<String> clefs = gestionPays.getCleDefaut();
                request.setAttribute("mapPays", mp);
                request.setAttribute("clefs", clefs);
                pageJSP = "/WEB-INF/pays.jsp";
            } catch (SQLException ex) {
                ex.printStackTrace();

                // to do
            }
        }

        pageJSP = response.encodeURL(pageJSP);
        getServletContext().getRequestDispatcher(pageJSP).include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
