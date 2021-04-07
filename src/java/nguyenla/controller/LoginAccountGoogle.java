/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.controller;

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
import nguyenla.tbluserhistory.UserHistoryDAO;
import nguyenla.tbluserhistory.UserHistoryDTO;
import nguyenla.tbluser.UserDAO;
import nguyenla.tbluser.UserDTO;

/**
 *
 * @author ANH NGUYEN
 */
public class LoginAccountGoogle extends HttpServlet {

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
    private String url;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            /* TODO output your page here. You may use following sample code. */
            String googleName = request.getParameter("txtUser");
            String googleFullName = request.getParameter("txtFullName");
            String checkAccount = UserDAO.checkLogin(googleName, "123");
            url = HOMEPAGE;

            if (checkAccount.equals("")) {

                UserDTO googleUser = new UserDTO(googleName, "123", googleFullName, true, false);
                UserDAO.addAccountGoogle(googleUser);

            }

            request.setAttribute("welcomeUser", "Welcome to " + googleName);
            session.setAttribute("User", googleName);
            session.setAttribute("member", googleName);
            session.setAttribute("accountGoogle", googleFullName);
            List<UserHistoryDTO> listUserHistory = new ArrayList<>();
            listUserHistory = UserHistoryDAO.getUserHistory(googleName);
            session.setAttribute("listUserHistory", listUserHistory);

            RequestDispatcher dis = request.getRequestDispatcher(url);
            dis.forward(request, response);
        } catch (SQLException ex) {
            log("LoginAccountGoogle: " + ex.getMessage());
        } catch (NamingException ex) {
            log("LoginAccountGoogle: " + ex.getMessage());
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
            Logger.getLogger(LoginAccountGoogle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LoginAccountGoogle.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginAccountGoogle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LoginAccountGoogle.class.getName()).log(Level.SEVERE, null, ex);
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
