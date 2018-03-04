package controleurs;

import accesBDD.LigneCommandeDAO;
import java.io.IOException;
import static java.lang.Math.round;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
import traitements.GestionPays;

@WebServlet(name = "ControllerMain", urlPatterns = {"/ControllerMain"})
public class ControllerMain extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String saisie = null;
        request.setAttribute("path", "/LibrairieFusion-v1.0/img/");
        String pageJSP = "/WEB-INF/jspMain.jsp";
        String section = request.getParameter("section");
        if ("menu-main".equals(section)) {
            pageJSP = "/WEB-INF/menus/menu-main.jsp";
        }
        if ("home".equals(section)) {
            pageJSP = "/WEB-INF/home.jsp";
        }
        if ("inscription".equals(section)) {
            pageJSP = "/WEB-INF/inscription2.jsp";
        }
        if ("catalogue".equals(section)) {
            try {
                pageJSP = "/WEB-INF/catalogue.jsp";
                GestionLivres maGestionLivre = new GestionLivres();
                ArrayList<Livres> mesLivres = maGestionLivre.findLivres(false, saisie);
                request.setAttribute("maListeLivres", mesLivres);
                //*******************************************************
                int sizeMesLivres = round(maGestionLivre.findLivres(false, "").size());
                request.setAttribute("sizeMesLivres", sizeMesLivres);
                ArrayList<Livres> mesLivres1 = maGestionLivre.findLivresPagin(0, 1);
                ArrayList<Livres> mesLivres2 = maGestionLivre.findLivresPagin(2, 3);
                ArrayList<Livres> mesLivres3 = maGestionLivre.findLivresPagin(4, 5);
                ArrayList<Livres> mesLivres4 = maGestionLivre.findLivresPagin(6, 7);
                ArrayList<Livres> mesLivres5 = maGestionLivre.findLivresPagin(8, 9);
                ArrayList<Livres> mesLivres6 = maGestionLivre.findLivresPagin(10, 11);
                ArrayList<ArrayList<Livres>> page1 = new ArrayList<>();
                ArrayList<ArrayList<Livres>> page2 = new ArrayList<>();
                ArrayList<ArrayList<Livres>> page3 = new ArrayList<>();
                ArrayList< ArrayList<ArrayList<Livres>>> listDeListDeList = new ArrayList<>();
                page1.add(mesLivres1);
                page1.add(mesLivres2);
                page2.add(mesLivres3);
                page2.add(mesLivres4);
                page3.add(mesLivres5);
                page3.add(mesLivres6);
                listDeListDeList.add(page1);
                listDeListDeList.add(page2);
                listDeListDeList.add(page3);
                request.setAttribute("listDeListDeList", listDeListDeList);
                //*******************************************************
                
                //*******************************************************
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
        if ("RechercheEvenement".equals(section)) {
            try {
                pageJSP = "/WEB-INF/Evenement.jsp";
                GestionEvenement maGestionEvenement = new GestionEvenement();
                ArrayList<Evenement> mesEvenements = maGestionEvenement.findEvenement(true, request.getParameter("rechercheEvenement"));

//                ArrayList<Evenement> s = new ArrayList<>();
//                for (Evenement mesEvenement : mesEvenements) {
//                    s.add(mesEvenement.getISBNLivre(),
//                          mesEvenement.getNomEvenement(),
//                          mesEvenement.getDateDebutEvenement(),
//                          mesEvenement.getDateFinEvenement(),
//                          mesEvenement.getDescriptionEvenement(),
//                          mesEvenement.getTypeEvenement(),
//                          mesEvenement.getTitreLivre(),
//                          mesEvenement.getCommentaireEvenement());
                request.setAttribute("mesEvenements", mesEvenements);

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
                for (LigneCommande ldc : lcom) {
                    System.out.println(ldc.getIDLigneCommande());
                }
                request.setAttribute("gestionLC", lcom);

            } catch (NamingException | SQLException ex) {
                ex.printStackTrace();
            }
        }

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
