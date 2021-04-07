/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.controller;

import nguyenla.tblfood.FoodDAO;
import nguyenla.tblfood.FoodDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nguyenla.tbluser.UserDAO;

/**
 *
 * @author ANH NGUYEN
 */
public class LoadHomePage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String HOME = "HomePage.jsp";
    private String url;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            System.out.println("Load Home Page");
            /* TODO output your page here. You may use following sample code. */
            List<FoodDTO> listFood = new ArrayList<>();
            List<FoodDTO> listFavour = new ArrayList<>();
            String indexPara = request.getParameter("index");
            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("member");
            
            
            String status = "active";
            url = HOME;

            listFavour = UserDAO.getFoodFavourite(user);
            System.out.println("listFavour");
            session.setAttribute("listFavour", listFavour);
            System.out.println(listFavour.size());
            int indexPage;
            if (indexPara == null) {
                indexPage = 1;
            } else {
                indexPage = Integer.parseInt(indexPara);
            }

            int pagingSize = 8;
            System.out.println("2");
            int countPage = FoodDAO.countHomePage();
            System.out.println("3");
            int endPage = countPage / pagingSize;
            if (countPage % pagingSize != 0) {
                endPage++;
            }
            System.out.println("ta");
            
            if (user == null) {
                listFood = FoodDAO.pageFood(indexPage);
                System.out.println("ListFood:"+listFood.size());
            } else {
                countPage = FoodDAO.countHomePageUser("active");
                endPage = countPage / pagingSize;
                if (countPage % pagingSize != 0) {
                    endPage++;
                }

                listFood = FoodDAO.pageUser(indexPage, "active");
            }

            request.setAttribute("endPage", endPage);
            System.out.println("Toi day");
            if (listFood != null) {
                request.setAttribute("listFoodHomePage", listFood);
            }
            request.setAttribute("index", indexPage);
            System.out.println("Toi day");
            RequestDispatcher dis = request.getRequestDispatcher(url);
            dis.forward(request, response);
        } catch (SQLException ex) {
            log("LoadHomePage: " + ex.getMessage());
        } catch (NamingException ex) {
            log("LoadHomePage: " + ex.getMessage());
        } finally {
            out.close();
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoadHomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LoadHomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoadHomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LoadHomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
