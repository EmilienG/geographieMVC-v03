package controleurs;

import accesBDD.LigneCommandeDAO;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static java.lang.Math.round;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import obj.Client;
import obj.Commande;
import obj.CoupDeCoeur;
import obj.Evenement;
import obj.LigneCommande;
import obj.Livres;
import traitements.GestionClients;
import traitements.GestionCommandes;
import traitements.GestionCoupDeCoeur;
import traitements.GestionCompte;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10000);
        String saisie = null;
        request.setAttribute("path", "/LibrairieFusion-v1.0/img/");
        String pageJSP = "/WEB-INF/home.jsp";
        String section = request.getParameter("section");

        Date maDate = new Date();
        String nextYear = "20" + String.valueOf(maDate.getYear() + 1).substring(1, 3);
        session.setAttribute("nextYear", nextYear);
        System.out.println();
        if (request.getParameter("login") != null) {
            try {
                GestionClients maGestionClients = new GestionClients();
                String monID = maGestionClients.afficherClientByName(request.getParameter("login"));
                System.out.println("Mon ID : " + monID);
                Client monClient = maGestionClients.afficherClientByID(monID);
                session.setAttribute("monClient", monClient);
            } catch (NamingException | SQLException ex) {
                ex.printStackTrace();
            }
        }

        if ("home".equals(section)) {
            pageJSP = "/WEB-INF/home.jsp";
        }
//-------------------CoupDeCoeur----------------------------

        if ("CoupDeCoeur".equals(section)) {
            try {
                pageJSP = "/WEB-INF/CoupDeCoeur.jsp";
                GestionCoupDeCoeur maGestionCoupDeCoeur = new GestionCoupDeCoeur();
                ArrayList<CoupDeCoeur> mesCoupDeCoeurs = maGestionCoupDeCoeur.findCoupDeCoeur(false, saisie);

                ArrayList<String> s = new ArrayList<>();

                session.setAttribute("mesCoupDeCoeurs", mesCoupDeCoeurs);
//                }

                System.out.println(s);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NamingException ex) {
                Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//----------------------------------------------------------

        //-------------------------------------------
        //Si on clic sur ajouter panier :
        if (request.getParameter("IDLivre") != null) {
            //On recupere le param (caché) IDLivre
            String IDLivre = request.getParameter("IDLivre");
            session.setAttribute("IDLivre", IDLivre);
        }
        if ("panier".equals(section)) {
            pageJSP = "/WEB-INF/panier.jsp";
        }

        if ("compte".equals(section)) {
            pageJSP = "/WEB-INF/compte.jsp";
        }
        if ("catalogue".equals(section)) {
            try {
                pageJSP = "/WEB-INF/catalogue.jsp";
                GestionLivres maGestionLivre = new GestionLivres();
                ArrayList<Livres> mesLivres = maGestionLivre.findLivres(false, saisie);
                request.setAttribute("maListeLivres", mesLivres);
                int sizeMesLivres = round(maGestionLivre.findLivres(false, "").size());
                request.setAttribute("sizeMesLivres", sizeMesLivres);

                ArrayList<Livres> mesLivres1 = maGestionLivre.findLivresPagin(false, saisie, 0, 1);
                ArrayList<Livres> mesLivres2 = maGestionLivre.findLivresPagin(false, saisie, 2, 3);
                ArrayList<Livres> mesLivres3 = maGestionLivre.findLivresPagin(false, saisie, 4, 5);
                ArrayList<Livres> mesLivres4 = maGestionLivre.findLivresPagin(false, saisie, 6, 7);
                ArrayList<Livres> mesLivres5 = maGestionLivre.findLivresPagin(false, saisie, 8, 9);
                ArrayList<Livres> mesLivres6 = maGestionLivre.findLivresPagin(false, saisie, 10, 11);

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
            } catch (NamingException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (getServletContext().getAttribute("GestionCompte") == null) {
            try {
                getServletContext().setAttribute("GestionCompte", new GestionCompte());
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
        GestionCompte bCompte = (GestionCompte) getServletContext().getAttribute("GestionCompte");
        if ("inscription".equals(section)) {
            pageJSP = "/WEB-INF/inscription.jsp";
            System.out.println("je suis dans la section inscription");
            if (request.getParameter("doIt2") != null) {
                System.out.println("jai appuyer sur ok");
                if (bCompte.check(request.getParameter("name2"), request.getParameter("prenom2"), request.getParameter("pseudo2"), request.getParameter("password2"), request.getParameter("email2"))) {
//                    try {
//                        bCompte.addCustomer(request.getParameter("name2"), request.getParameter("prenom2"), request.getParameter("password2"),request.getParameter("email2"));
//                    } catch (SQLException ex) {
//                        Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    System.out.println("tout les champs son remplis");
                    pageJSP = "/WEB-INF/home.jsp";
                    String nom = request.getParameter("name");
                    request.setAttribute("welcome", nom);
                } else {
                    System.out.println("champs manquant");
                    pageJSP = "/WEB-INF/inscription.jsp";
                    request.setAttribute("msg", "veuillez remplir tout les champs !!!");
                }
            }
        }

        if ("Evenement".equals(section)) {
            try {
                pageJSP = "/WEB-INF/Evenement.jsp";
                GestionEvenement maGestionEvenement = new GestionEvenement();
                ArrayList<Evenement> mesEvenements = maGestionEvenement.findEvenement(false, saisie);
                session.setAttribute("mesEvenements", mesEvenements);
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
                pageJSP = "/WEB-INF/catalogue.jsp";
                GestionLivres maGestionLivre = new GestionLivres();
                ArrayList<Livres> mesLivres = maGestionLivre.findLivres(true, request.getParameter("recherche"));
                request.setAttribute("maListeLivres", mesLivres);
                ArrayList<Livres> mesLivres1 = maGestionLivre.findLivresPagin(true, request.getParameter("recherche"), 0, 1);
                ArrayList<Livres> mesLivres2 = maGestionLivre.findLivresPagin(true, request.getParameter("recherche"), 2, 3);
                ArrayList<Livres> mesLivres3 = maGestionLivre.findLivresPagin(true, request.getParameter("recherche"), 4, 5);
                ArrayList<Livres> mesLivres4 = maGestionLivre.findLivresPagin(true, request.getParameter("recherche"), 6, 7);
                ArrayList<Livres> mesLivres5 = maGestionLivre.findLivresPagin(true, request.getParameter("recherche"), 8, 9);
                ArrayList<Livres> mesLivres6 = maGestionLivre.findLivresPagin(true, request.getParameter("recherche"), 10, 11);
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
            } catch (NamingException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

//=====================COMMANDES================================================        
        if ("order".equals(section)) {
//            System.out.println("hello");
//            String monIDcompte = session.getAttribute("IDcompte").toString();
//
//            try {
//                pageJSP = "/WEB-INF/order.jsp";
//                GestionCommandes gestionC = new GestionCommandes();
//                List<Commande> com = gestionC.findOrder();
//                request.setAttribute("gestionC", com);
//            } catch (NamingException | SQLException ex) {
//                ex.printStackTrace();
//            }
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

/////////////////////////////////LOGIN//////////////////////////////////////////////////////////
        //Par defaut pas logué
        if (getCookie(request.getCookies(), "login") == null) {
            session.setAttribute("logOn", false);
        }

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
            //Pour aller sur la page d'acceuil quand on se log
//            pageJSP = "/WEB-INF/home.jsp";
//            System.out.println(">>>>>>>>>>>>>>>>>Cookie:" + pageJSP);
            request.setAttribute("welcome", c.getValue());
            session.setAttribute("logOn", true);
        }
        if ("menu-main".equals(section)) {
            pageJSP = "/WEB-INF/menus/menu-main.jsp";
        }
        if ("footer".equals(section)) {
            pageJSP = "/WEB-INF/menus/footer.jsp";
        }

        if ("deconnecter".equals(section)) {
            pageJSP = "/WEB-INF/home.jsp";
//            pageJSP = "/WEB-INF/menus/menu-main.jsp";
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + pageJSP);
            Cookie cc = new Cookie("login", "");
            cc.setMaxAge(0);
            session.setAttribute("logOn", false);
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
            if (request.getParameter("IDCompte") != null) {
                String hiddenIDcomtpe = request.getParameter("IDCompte");
                System.out.println("monHiddenCompte = " + hiddenIDcomtpe);
                session.setAttribute("IDCompte2", hiddenIDcomtpe);
//                boolean rempli = false;
//                System.out.println("rempli faux");
//                if (request.getParameter("login") != null && request.getParameter("password") != null) {
//                    rempli = true;
//                    System.out.println("rempli ok");
//                }
            }
            pageJSP = "/WEB-INF/jspLogin.jsp";
            if (request.getParameter("doIt") != null) {
                if (bLogin.check(request.getParameter("login"), request.getParameter("password"))) {
                    System.out.println("Connexion Réussie");
                    session.setAttribute("logOn", true);
                    pageJSP = "/WEB-INF/home.jsp";
                    String login = request.getParameter("login");
                    request.setAttribute("name", login);
                    c = new Cookie("login", login);
                    c.setMaxAge(10000);
                    c.setPath(File.separator);
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
                        System.out.println("nouveau cookie essai" + c.toString());
                    } else {
                        System.out.println("cookie existant" + c.toString());
                        c.setValue(c.getValue() + "*");
                    }
                    c.setMaxAge(9);
                    System.out.println(c.getValue());
                    response.addCookie(c);
                    if (c.getValue().length() >= 3) {
                        pageJSP = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", "Trop de tentatives !!!");
                    }
                }
            }
        }

//=====================COMMANDES================================================        
        if ("order".equals(section)) {
//            System.out.println("hello");

            try {
                if (session.getAttribute("logOn") != null) {
                    Client cl = new Client();
                    pageJSP = "/WEB-INF/order.jsp";
                    GestionCommandes gestionC = new GestionCommandes();
                    List<Commande> com = gestionC.findOrder(cl.getId());
//                List<Commande> com = gestionC.findOrder(cl);
                    request.setAttribute("gestionC", com);
                }
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
        String lol = "<span id=\"cgu\"><a href=\"ControllerMain?section=hidden\">*</a></span>";
        session.setAttribute("lol", lol);
        if ("hidden".equals(section)) {
            pageJSP = "/WEB-INF/hidden.jsp";
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
