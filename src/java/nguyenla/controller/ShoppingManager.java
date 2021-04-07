/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANH NGUYEN
 */
public class ShoppingManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String HOMEPAGE = "LoadHomePage";
    private final String LOGINSERVER = "LoginServlet";
    private final String LOGOUTSERVER = "LogoutServlet";
    private final String SEARCHFOODSERVER = "SearchFoodServlet";
    private final String SELECTEDFOODSERVER = "SelectedFoodServlet";
    private final String HISTORY = "GetHistory";
    private final String GETINFO = "GetInfoUpdate";
    private final String UPDATEFOODSERVER = "UpdateFoodServlet";
    private final String DELETESERVER = "DeleteFoodServlet";
    private final String ADDFOODSERVER = "AddFoodServlet";
    private final String ADDCARTSERVER = "AddToCartServlet";
    private final String REMOVECARTSERVER = "RemoveCartServlet";
    private final String CHECKOUTCARTSERVER = "CheckOutCart";
    private final String CONFIRMAMOUNTSERVER = "ClickUpdateServlet";
    private final String UPDATEAMOUNTSERVER = "UpdateCartServlet";
    private final String LOGINGOOGLE = "LoginAccountGoogle";
    private final String SEARCHHISTORY = "SearchShoppingHistory";
    private final String CHECKQUANTITYPAYPAL = "CheckQuantityPaypalServlet";
    private final String DELETERECORDPAGE = "DeleteRecord.jsp";
    private final String ADDFOODPAGE = "AddFood.jsp";
    private final String CARTPAGE = "ShoppingCart.jsp";
    private final String USERHISTORYPAGE = "UserHistory.jsp";
    private final String LOGINPAGE = "LoginAccount.jsp";
    private String url;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("btAction");
            if (action == null) {
                url = HOMEPAGE;
            } else if (action.equalsIgnoreCase("login Account")) {
                url = LOGINSERVER;
            } else if (action.equalsIgnoreCase("logOut")) {
                url = LOGOUTSERVER;
            } else if (action.equalsIgnoreCase("search")) {
                url = SEARCHFOODSERVER;
            } else if (action.equalsIgnoreCase("homePage")) {
                url = HOMEPAGE;
            } else if (action.equalsIgnoreCase("deleteFood")) {
                url = SELECTEDFOODSERVER;
            } else if (action.equalsIgnoreCase("history")) {
                url = HISTORY;
            } else if (action.equalsIgnoreCase("update")) {
                url = GETINFO;
            } else if (action.equalsIgnoreCase("updateFood")) {
                url = UPDATEFOODSERVER;
            } else if (action.equalsIgnoreCase("remove")) {
                url = DELETESERVER;
            } else if (action.equalsIgnoreCase("add")) {
                url = ADDFOODSERVER;
            } else if (action.equalsIgnoreCase("addCart")) {
                url = ADDCARTSERVER;
            } else if (action.equalsIgnoreCase("remove Cart")) {
                url = REMOVECARTSERVER;
            } else if (action.equalsIgnoreCase("proceed to check out")) {
                url = CHECKOUTCARTSERVER;
            } else if (action.equalsIgnoreCase("update Amount")) {
                url = CONFIRMAMOUNTSERVER;
            } else if (action.equalsIgnoreCase("confirm")) {
                url = UPDATEAMOUNTSERVER;
            } else if (action.equalsIgnoreCase("accountGoogle")) {
                url = LOGINGOOGLE;
            } else if (action.equalsIgnoreCase("search Food")) {
                url = SEARCHHISTORY;
            } else if (action.equalsIgnoreCase("deleteRecordPage")) {
                url = DELETERECORDPAGE;
            } else if (action.equalsIgnoreCase("addFoodPage")) {
                url = ADDFOODPAGE;
            } else if (action.equalsIgnoreCase("shoppingCart")) {
                url = CARTPAGE;
            } else if (action.equalsIgnoreCase("userHistory")) {
                url = USERHISTORYPAGE;
            } else if (action.equalsIgnoreCase("loginAccount")) {
                url = LOGINPAGE;
            }
            RequestDispatcher dis = request.getRequestDispatcher(url);
            dis.forward(request, response);
        } catch (Exception e) {
            log("ShoppingManager: " + e.getMessage());
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
