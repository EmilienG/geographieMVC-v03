package controleurs;

import accesBDD.ClientDAO;
import accesBDD.LigneCommandeDAO;
import beans.beanPanier;
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
import traitements.GestionLigneCommandes;
import traitements.GestionLivres;
import traitements.GestionLogin;

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException, IOException, NamingException {
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

        if (request.getParameter("login") != null) {
            try {
                GestionClients maGestionClients = new GestionClients();
                String loginByField = request.getParameter("login");

                Cookie cookLog = new Cookie("log", loginByField);
                cookLog.setMaxAge(10000);
                cookLog.setPath(File.separator);
                response.addCookie(cookLog);

                String monID = maGestionClients.afficherClientByName(loginByField);
//                System.out.println("Mon ID : " + monID);

//                Client monClient = maGestionClients.afficherClientByID(monID);
//                session.setAttribute("monClient", monClient);
                session.setAttribute("monClient", monID);

            } catch (NamingException | SQLException ex) {
                ex.printStackTrace();
            }
        } else if (request.getParameter("log") == null) {
            if (getCookie(request.getCookies(), "log") != null) {
                Cookie monCookLog = getCookie(request.getCookies(), "log");
//                System.out.println("Tazeaz : " + monCookLog);
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

                for (CoupDeCoeur mesCoupDeCoeur : mesCoupDeCoeurs) {

//                    System.out.println(mesCoupDeCoeur.getTitreClean());
                }
                session.setAttribute("mesCoupDeCoeurs", mesCoupDeCoeurs);

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NamingException ex) {
                Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//----------------------------------------------------------
        if ("catalog".equals(request.getParameter("section"))) {
            pageJSP = "/WEB-INF/catalogue.jsp";
        }
        if ("panier".equals(request.getParameter("section"))) {
            beanPanier monPanier = (beanPanier) session.getAttribute("monPanier");
            if (monPanier == null) {
                monPanier = new beanPanier();
                session.setAttribute("monPanier", monPanier);
            }
            if (request.getParameter("add") != null) {
                monPanier.add(request.getParameter("add"));
            }
            if (request.getParameter("dec") != null) {
                monPanier.dec(request.getParameter("dec"));
            }
            if (request.getParameter("del") != null) {
                monPanier.del(request.getParameter("del"));
            }
            if (request.getParameter("clear") != null) {
                monPanier.clear();
            }
        }
        if ("affichePanier".equals(request.getParameter("section"))) {
            pageJSP = "/WEB-INF/cart.jsp";
            beanPanier monPanier = (beanPanier) session.getAttribute("monPanier");
            if (monPanier == null) {
                monPanier = new beanPanier();
                session.setAttribute("monPanier", monPanier);
            }
            request.setAttribute("panierVide", monPanier.isEmpty());
            request.setAttribute("list", monPanier.list());
        }
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

            if (request.getParameter("modifierCompte") != null) {
                Client monCompte = new Client();
                monCompte.setNom(request.getParameter("name"));
                monCompte.setPrenom(request.getParameter("prenom"));
                monCompte.setPseudo(request.getParameter("pseudo"));
                monCompte.setEmail(request.getParameter("email"));
                monCompte.setTelephone(request.getParameter("tel"));
                monCompte.setMDP(request.getParameter("password"));
                session.setAttribute("monCompte", monCompte);
                //Ici faire requete SQL pour update
//                System.out.println("Nouveau Pseudo=" + monCompte.getPseudo());
                GestionCompte ges = new GestionCompte();
//                try {
//                    ges.modifCompte(session.getAttribute("monClient").toString(), request.getParameter("name"), request.getParameter("pseudo"), request.getParameter("prenom"), request.getParameter("email"), request.getParameter("tel"), request.getParameter("password"));
//                } catch (SQLException ex) {
//                    Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
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

        if ("inscription".equals(section)) {
            pageJSP = "/WEB-INF/inscription.jsp";
            if (request.getParameter("doIt2") != null) {
                if (!request.getParameter("name2").equalsIgnoreCase("") && !request.getParameter("prenom2").equalsIgnoreCase("") && !request.getParameter("pseudo2").equalsIgnoreCase("") && !request.getParameter("password2").equalsIgnoreCase("") && !request.getParameter("email2").equalsIgnoreCase("")) {;
                    try {
                        GestionCompte bCompte = (GestionCompte) getServletContext().getAttribute("GestionCompte");
                        bCompte.addCustomer(request.getParameter("name2"), request.getParameter("prenom2"), request.getParameter("pseudo2"), request.getParameter("password2"), request.getParameter("email2"));

//                        System.out.println("tout les champs son remplis");
                        pageJSP = "/WEB-INF/home.jsp";
                        String nom = request.getParameter("name");
                        request.setAttribute("welcome", nom);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);

                    }

                } else {
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
                request.setAttribute("mesEvenements", mesEvenements);

            } catch (NamingException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if ("RechercheCoupDeCoeur".equals(section)) {
            try {
                pageJSP = "/WEB-INF/CoupDeCoeur.jsp";
                GestionCoupDeCoeur maGestionCoupDeCoeur = new GestionCoupDeCoeur();
                ArrayList<CoupDeCoeur> mesCoupDeCoeurs = maGestionCoupDeCoeur.findCoupDeCoeur(true, request.getParameter("rechercheCoupDeCoeur"));
                session.setAttribute("mesCoupDeCoeurs", mesCoupDeCoeurs);
//                GestionEvenement maGestionEvenement = new GestionEvenement();
//                ArrayList<Evenement> mesEvenements = maGestionEvenement.findEvenement(true, request.getParameter("rechercheEvenement"));
//                request.setAttribute("mesEvenements", mesEvenements);

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
//        if ("order".equals(section)) {
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
//        }

//
//        if ("orderLine".equals(section)) {
//            System.out.println("hello");
//            try {
//                pageJSP = "/WEB-INF/orderLine.jsp";
//                LigneCommandeDAO gestionLC = new LigneCommandeDAO();
//                List<LigneCommande> lcom = gestionLC.selectAllOrderLineByOrder();
//                for (LigneCommande ldc : lcom) {
//                    System.out.println(ldc.getIDLigneCommande());
//                }
//                request.setAttribute("gestionLC", lcom);
//
//            } catch (NamingException | SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        if ("orderLine".equals(section)) {
////            System.out.println("hello");
//            try {
//                pageJSP = "/WEB-INF/orderLine.jsp";
//                LigneCommandeDAO gestionLC = new LigneCommandeDAO();
//                List<LigneCommande> lcom = gestionLC.viewOrderLineByOrder();
//                for (LigneCommande ldc : lcom) {
//                    System.out.println(ldc.getIDLigneCommande());
//                }
//                request.setAttribute("gestionLC", lcom);
//
//            } catch (NamingException ex) {
//                ex.printStackTrace();
//            }
//        }
/////////////////////////////////LOGIN//////////////////////////////////////////////////////////
//        //Par defaut pas logué
//        if (getCookie(request.getCookies(), "login") == null) {
//            session.setAttribute("logOn", false);
//        }
        if (getServletContext().getAttribute("GestionLogin") == null) {
            try {
                getServletContext().setAttribute("GestionLogin", new GestionLogin());
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }

        GestionLogin bLogin = (GestionLogin) getServletContext().getAttribute("GestionLogin");
        Cookie c = null;

        if ("menu-main".equals(section)) {
            pageJSP = "/WEB-INF/menus/menu-main.jsp";
        }
        if ("footer".equals(section)) {
            pageJSP = "/WEB-INF/menus/footer.jsp";
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
                session.setAttribute("IDCompte2", hiddenIDcomtpe);
            }
            pageJSP = "/WEB-INF/jspLogin.jsp";
            if (request.getParameter("doIt") != null) {
                if (bLogin.check(request.getParameter("login"), request.getParameter("password"))) {
//                    System.out.println("Connexion Réussie");
                    request.setAttribute("welcome", request.getParameter("login"));
                    session.setAttribute("logOn", true);
//                    System.out.println(330 + "/" + session.getAttribute("logOn"));
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
//                        System.out.println("nouveau cookie essai" + c.toString());
                    } else {
//                        System.out.println("cookie existant" + c.toString());
                        c.setValue(c.getValue() + "*");
                    }
                    c.setMaxAge(9);
//                    System.out.println(c.getValue());
                    response.addCookie(c);
                    if (c.getValue().length() >= 3) {
                        pageJSP = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", "Trop de tentatives !!!");
                    }
                }
            }
        }
        c = getCookie(request.getCookies(), "login");
        if (c != null) {
            //Pour aller sur la page d'acceuil quand on se log
//            pageJSP = "/WEB-INF/home.jsp";
//            System.out.println(">>>>>>>>>>>>>>>>>Cookie:" + pageJSP);
            request.setAttribute("welcome", c.getValue());
            if (session.getAttribute("logOn") != null) {
                if ((boolean) session.getAttribute("logOn")) {
                    session.setAttribute("logOn", true);
                }
            } else {
                session.setAttribute("logOn", true);
            }
//            System.out.println(375 + "/" + session.getAttribute("logOn"));
        }
        if ("deconnecter".equals(section)) {
//            System.out.println(">>>>>>>>>>>deconnecter");
            pageJSP = "/WEB-INF/home.jsp";
//            pageJSP = "/WEB-INF/menus/menu-main.jsp";
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + pageJSP);
            session.setAttribute("logOn", false);
            session.setAttribute("monClient", null);
//            System.out.println(378 + "/" + session.getAttribute("logOn"));

            Cookie cc = new Cookie("login", "");
            cc.setMaxAge(0);
            response.addCookie(cc);
        }

//=====================COMMANDES================================================        
//       System.out.println("therherher   "+session.getAttribute("monClient"));
        if ("order".equals(section)) {
//            System.out.println("hello section order");
//            boolean deco = false;
            if ((boolean) session.getAttribute("logOn")) {
                try {
                    System.out.println("session = " + session.getAttribute("monClient").toString());
//                deco = true;
                    pageJSP = "/WEB-INF/order.jsp";
//                System.out.println("coucou ID n° " + session.getAttribute("monClient").toString());
                    GestionCommandes gestionC = new GestionCommandes();
                    List<Commande> com = gestionC.findOrder(session.getAttribute("monClient").toString());
                    request.getParameter("audrey");
//                System.out.println("je suis audrey" + request.getParameter("audrey"));
//                System.out.println("commande " + com);
                    request.setAttribute("gestionC", com);
//                System.out.println("hello if get id");
                } catch (NamingException | SQLException ex) {
                    ex.printStackTrace();
                }

            }

//            c = getCookie(request.getCookies(), "order");
//            if(){
//                session.getId();
//            }
//            response.addCookie(c);
        }

        if ("orderLine".equals(section)) {
//            System.out.println("hello order line");
            try {
//                System.out.println("hello get id orderline");
                pageJSP = "/WEB-INF/orderLine.jsp";
//                System.out.println("je suis audrey dans ma ligne de commande" + request.getParameter("audrey"));
//                GestionLivres gestionLv = new GestionLivres();
//                List<Livres> lv = gestionLv.findBookByOrder(session.getAttribute("monClient").toString());
//                request.setAttribute("gestionLv", lv);
                GestionLigneCommandes gestionLC = new GestionLigneCommandes();
//                List<LigneCommande> lcom = gestionLC.findOrderLineByOrder(session.getAttribute("monClient").toString());
//                List<Livres> lvs = gestionLC.findBookByOrder(session.getAttribute("monClient").toString());
                List<LigneCommande> lcom = gestionLC.findOrderLineByOrder(request.getParameter("audrey"));
                List<Livres> lvs = gestionLC.findBookByOrder(request.getParameter("audrey"));
                for (Livres lv : lvs) {
//                    System.out.println("id orderline " + lv.getIDLivre());

                }
//                System.out.println(lvs);
                session.setAttribute("gestionLC", lcom);
                session.setAttribute("gestionLV", lvs);
//                boolean monBool = false;
//                if () {
//                    boolean monBool = false;
//                }

            } catch (NamingException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        if ("don".equals(section)) {
            pageJSP = "/WEB-INF/don.jsp";
        }
        String lol = "<span id=\"cgu\"><a href=\"ControllerMain?section=hidden\">*</a></span>";
        session.setAttribute("lol", lol);
        if ("hidden".equals(section)) {
            pageJSP = "/WEB-INF/hidden.jsp";
        }
        pageJSP = response.encodeURL(pageJSP);
//        System.out.println(pageJSP + "/" + session.getAttribute("logOn"));
        getServletContext().getRequestDispatcher(pageJSP).include(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
