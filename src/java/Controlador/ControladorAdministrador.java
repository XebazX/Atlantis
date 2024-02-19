/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebas
 */
@WebServlet(name = "ControladorAdministrador", urlPatterns = {"/ControladorAdministrador"})
public class ControladorAdministrador extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        String id = request.getParameter("fIdAdministrador");
        String CorreoAdm = request.getParameter("fCorreoAdm");
        String ContraseñaAdm = request.getParameter("fCAdm");
        String accion = request.getParameter("fAccion");
        System.out.println("contrasña   "+ request.getParameter("fCAdm"));
        System.out.println("Entra correo-contra"+id +" "  +CorreoAdm + " "+ContraseñaAdm);
        int IdAdministrador = 0;
        try {
            IdAdministrador = Integer.parseInt(id);
        } catch (NumberFormatException nte) {
        }
        
        Administrador unAdministrador = new Administrador();
        unAdministrador.setIdAdministrador(IdAdministrador);
        unAdministrador.setCorreoAdm(CorreoAdm);
        unAdministrador.setContraseñaAdm(ContraseñaAdm);
        
        String mensaje = "";
        switch (accion) {
            case "Insertar":
                unAdministrador.Insertar();
                mensaje="Insertaste  un Administrador";
            break;
            case "Modificar":
                unAdministrador.modificar();
                mensaje = "Modificaste un Administrador";
                break;
            case "Eliminar":
                unAdministrador.Eliminar();
                mensaje = "Eliminaste un Administrador";
                break;
                
                
                default:
                    System.out.println("no hay opcion ");
        }
                request.getRequestDispatcher("WEB-INF/Administradores.jsp?msj=" + mensaje).forward(request, response);
        
        
        
    
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
