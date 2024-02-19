/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
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
@WebServlet(name = "ControladorCliente1", urlPatterns = {"/ControladorCliente1"})
public class ControladorCliente1 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCliente at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("fidcliente");
        String nombre = request.getParameter("fnombreCliente");
        String documento = request.getParameter("fdocumentoCliente");
        String direccion = request.getParameter("fdireccionCliente");
        String celular = request.getParameter("fcelularCliente");
        String accion = request.getParameter("fAccion");
        
        int idcliente = 0;
        try {
            idcliente = Integer.parseInt(id);
        } catch (NumberFormatException nte) {
        }

        Cliente unCliente = new Cliente();
        unCliente.setIdCliente(idcliente);
        unCliente.setNombreCliente(nombre);
        unCliente.setDocumentoCliente(documento);
        unCliente.setDireccionCliente(direccion);
        unCliente.setCelularCliente(celular);
        
        String mensaje = "";
        switch (accion) {
            case "Insertar":
                unCliente.Insertar();
                mensaje="Insertaste  un Cliente";
            break;
            case "Modificar":
                unCliente.modificar();
                mensaje = "Modificaste un Cliente";
                break;
            case "Eliminar":
                unCliente.Eliminar();
                mensaje = "Eliminaste un Clente";
                break;
                
                
                default:
                    System.out.println("no hay opcion ");
        }
                request.getRequestDispatcher("WEB-INF/FormularioClienteAdm.jsp?msj=" + mensaje).forward(request, response);
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
