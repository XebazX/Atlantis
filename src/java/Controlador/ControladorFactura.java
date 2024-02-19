/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Carrito;
import Modelo.Cliente;
import Modelo.DetallesFacturas;
import Modelo.Factura;
import Modelo.Producto;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Sebas
 */
@WebServlet(name = "ControladorFactura", urlPatterns = {"/ControladorFactura"})
public class ControladorFactura extends HttpServlet {

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
        Factura factura = new Factura();
        factura.setFechaFactura("NOW()");
        HttpSession Xebaz = request.getSession();
        

        factura.setIdCliente((int) Xebaz.getAttribute("idU"));
        factura.setTotalFactura(Carrito.getTotalfinal());
        factura.insertar();

        System.out.println("tama;o vector " + Carrito.tamaño());
        for (int i = 0; i < Carrito.tamaño(); i++) {
            System.out.println("entra al for");
            DetallesFacturas detalle = new DetallesFacturas();
            Producto producto = Carrito.obtenerProducto(i);
            System.out.println("producto idproducto " + producto.getIdProducto());
            detalle.setIdFactura(factura.getIdFactura());
            detalle.setIdProducto(producto.getIdProducto());
            detalle.setSubtotalDetalle(producto.getPrecioProducto());
            detalle.setCantidadDetalle(1);

            detalle.insertar();
        }
        System.out.println("id generado controlador " + factura.getIdFactura());
        System.out.println("factura insertada");
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
