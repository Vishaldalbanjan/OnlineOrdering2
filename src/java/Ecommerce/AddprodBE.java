/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moham
 */
public class AddprodBE extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddprodBE</title>");            
            out.println("</head>");
            out.println("<body>");
            String pname = request.getParameter("pname");
            Long pprice = Long.parseLong(request.getParameter("pcost"));
            //int pid = Integer.parseInt(request.getParameter("cid"));
/*
            out.println("Product image:" + image);
            out.println("Product name:" + pname);
            out.println("Product category:" + category);
            out.println("Product price:" + pprice);
            out.println("Product quantity:" + quantity);
   */         

//out.println("<h1>Servlet AddAttdBE at " + request.getContextPath() + "</h1>");
            Connection con = DbConnection.getConnectToEco();
            String sql = "INSERT INTO product(pname,pcost) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,pname);
            ps.setLong(2,pprice);
           
            //ps.setInt(4, cid);
            int i = ps.executeUpdate();
            if (i > 0) {
                 out.println("<script>");
                 out.println("    var confirmation1 = confirm('YAYYYY!!! Product Added');");
                 out.println("    if (confirmation1) {");
                 out.println("        window.location.href ='AdminPanel.html';"); // Change the URL here
                 out.println("    } else {");
                 out.println("        window.location.href ='addprod.html';");
                 out.println("    }");
                 out.println("</script>");
                }
            con.close();
            out.println("</body>");
            out.println("</html>");
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
            Logger.getLogger(AddprodBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddprodBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddprodBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddprodBE.class.getName()).log(Level.SEVERE, null, ex);
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
