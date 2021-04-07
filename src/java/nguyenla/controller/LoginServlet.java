/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.controller;


import nguyenla.tbluser.UserDAO;
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

/**
 *
 * @author ANH NGUYEN
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String typeError = "";
    private final String LOGIN = "LoginAccount.jsp";
    private final String HOMEPAGE = "LoadHomePage";
    private String url;
    private String welcome;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        url = LOGIN;
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();

            String userName = request.getParameter("txtUser").trim();
            String userPasswords = request.getParameter("password").trim();
            String nameCase = UserDAO.checkLogin(userName, userPasswords).trim();

            if (!nguyenla.validation.Valid.checkEmpty(userName)) {
                typeError = "userName not empty !!";
            } else if (!nguyenla.validation.Valid.checkEmpty(userPasswords)) {
                typeError = "Passwords not empty !!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(userName)) {
                typeError = "userName doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(userPasswords)) {
                typeError = "Passwords doesn't contain special character!!";
            } else if (!userName.equals(nameCase)) {
                typeError = "Account not valid!!";
            } else {
                String checkUser = UserDAO.checkLogin(userName, userPasswords).trim();
                if (!checkUser.equals("admin")) {
                    request.setAttribute("welcomeUser", "Welcome to " + userName);
                    session.setAttribute("User", userName);
                    session.setAttribute("member", userName);
                    url = HOMEPAGE;
                } else if (checkUser.equals("admin")) {
                    request.setAttribute("welcomeUser", "Welcome to " + userName);
                    session.setAttribute("admin", userName);
                    url = HOMEPAGE;
                } else {
                    typeError = "Don't have this account in system!!";
                }
            }

            request.setAttribute("nameUser", userName);
            request.setAttribute("passwordUser", userPasswords);
            request.setAttribute("error", typeError);
            List<UserHistoryDTO> listUserHistory = new ArrayList<>();
            listUserHistory = UserHistoryDAO.getUserHistory(userName);
            session.setAttribute("listUserHistory", listUserHistory);
            RequestDispatcher dis = request.getRequestDispatcher(url);
            dis.forward(request, response);

        } catch (SQLException ex) {
            log("LoginServlet: " + ex.getMessage());
        } catch (NamingException ex) {
            log("LoginServlet: " + ex.getMessage());
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
