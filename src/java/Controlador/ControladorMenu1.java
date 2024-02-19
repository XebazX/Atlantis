/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebas
 */
@WebServlet(name = "ControladorMenu1", urlPatterns = {"/ControladorMenu1"})
public class ControladorMenu1 extends HttpServlet {

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
        String opcion = request.getParameter("opcion");
        
        switch (opcion) {
            
            
            case "Carrito":
             
                request.getRequestDispatcher("WEB-INF/Carrito.jsp").forward(request, response);
                break;
            case "loginc":
             
                request.getRequestDispatcher("WEB-INF/InicioSesionCliente.jsp").forward(request, response);
                break;
            case "sesioncliente":
             
                request.getRequestDispatcher("WEB-INF/INDEXC.jsp").forward(request, response);
                break;
            case "Index":
             
                request.getRequestDispatcher("index.html").forward(request, response);
                break;
            case "categorias":
             
                request.getRequestDispatcher("WEB-INF/Categoria.jsp").forward(request, response);
                break;
            case "ClienteAdm":
             
                request.getRequestDispatcher("WEB-INF/FormularioClienteAdm.jsp").forward(request, response);
                break;
            case "IndexIniciada":
             
                request.getRequestDispatcher("WEB-INF/IndexIniciada.jsp").forward(request, response);
                break;
            case "Productos":
             
                request.getRequestDispatcher("WEB-INF/FormularioProducto.jsp").forward(request, response);
                break;
            case "Administradores":
                request.getRequestDispatcher("WEB-INF/Administradores.jsp").forward(request, response);
                break;
            case "InicioSesion":
                request.getRequestDispatcher("WEB-INF/InicioSesion.jsp").forward(request, response);
                break;
            case "FormCliente":
                request.getRequestDispatcher("WEB-INF/FormularioCliente.jsp").forward(request, response);
            break;
            default:
                request.getRequestDispatcher("/index.html").forward(request, response);
            break;
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
