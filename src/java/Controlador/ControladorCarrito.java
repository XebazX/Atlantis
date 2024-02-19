package Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Modelo.Carrito;
import Modelo.Producto;
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
@WebServlet(name = "ControladorCarrito", urlPatterns = {"/ControladorCarrito"})
public class ControladorCarrito extends HttpServlet {

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
        System.out.println("entra al carrito");
         String id = request.getParameter("fidProducto");
        String nombre = request.getParameter("fnombreProducto");
        String detalle = request.getParameter("fdetalleProducto");
        String precio = request.getParameter("fprecioProducto");
        String stock = request.getParameter("fstockProducto");
        String accion = request.getParameter("fAccion");

        
        
        
        System.out.println("esta es la opcion"+accion);
        
        
        int idProducto = 0;

        try {
            idProducto = Integer.parseInt(id);

        } catch (NumberFormatException nfe) {
            System.out.println("Error en el id");
        }
        
 
    
        
        int preciio = 0;
        try {
            preciio = Integer.parseInt(precio);
        } catch (NumberFormatException nte) {
            System.out.println("error en el prciio");
        }
        System.out.println("despues de los ty");
        Producto producto = new Producto();
        
        producto.setIdProducto(idProducto);
        producto.setNombreProducto(nombre);
        producto.setDetalleProducto(detalle);
        producto.setPrecioProducto(preciio);
        producto.setStockProducto(stock);
        
        String mensaje = "";
        switch (accion) {
            case "Agregar":
                Carrito.insertar(producto);
                mensaje =  "insertaste un producto al carrito";
            break;
            case "Eliminar":
                Carrito.eliminar(producto);
                mensaje =  "eliminaste un producto al carrito";
            break;
            default:
                System.out.println("No hay opcion ");
        }
       
        request.getRequestDispatcher("WEB-INF/Carrito.jsp").forward(request, response);
        
        
        
        
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
