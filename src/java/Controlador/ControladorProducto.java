/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Producto;
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
@WebServlet(name = "ControladorProducto", urlPatterns = {"/ControladorProducto"})
public class ControladorProducto extends HttpServlet {

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
            out.println("<title>Servlet ControladorProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProducto at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("fidProducto");
        String nombre = request.getParameter("fnombreProducto");
        String detalle = request.getParameter("fdetalleProducto");
        String precio = request.getParameter("fprecioProducto");
        String stock = request.getParameter("fstockProducto");
        String categoria = request.getParameter("fCategoria_idCategoria");
        String accion = request.getParameter("fAccion");
        
        int idProducto = 0;
        try {
            idProducto = Integer.parseInt(id);
        } catch (NumberFormatException nte) {
        }
        
        int categoriai = 0;
        try {
            categoriai = Integer.parseInt(categoria);
        } catch (NumberFormatException nte) {
        }
        
        int preciio = 0;
        try {
            preciio = Integer.parseInt(precio);
        } catch (NumberFormatException nte) {
        }

        Producto unProducto = new Producto();
        unProducto.setIdProducto(idProducto);
        unProducto.setNombreProducto(nombre);
        unProducto.setDetalleProducto(detalle);
        unProducto.setPrecioProducto(preciio);
        unProducto.setStockProducto(stock);
        unProducto.setCategoria(categoriai);
        
        
        
        String mensaje = "";
        switch (accion) {
            case "Insertar":
                unProducto.Insertar();
                mensaje="Insertaste  un Producto";
            break;
            case "Modificar":
                unProducto.modificar();
                mensaje = "Modificaste un Producto";
                break;
            case "Eliminar":
                unProducto.Eliminar();
                mensaje = "Eliminaste un Producto";
                break;
                
                
                default:
                    System.out.println("no hay opcion ");
        }
                request.getRequestDispatcher("WEB-INF/FormularioProducto.jsp?msj=" + mensaje).forward(request, response);
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
