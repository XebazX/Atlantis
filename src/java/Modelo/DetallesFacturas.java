/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebas
 */
public class DetallesFacturas {

    int idDetalle;
    int subtotalDetalle;
    int cantidadDetalle;
    int idProducto;
    int idFactura;

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getSubtotalDetalle() {
        return subtotalDetalle;
    }

    public void setSubtotalDetalle(int subtotalDetalle) {
        this.subtotalDetalle = subtotalDetalle;
    }

    public int getCantidadDetalle() {
        return cantidadDetalle;
    }

    public void setCantidadDetalle(int cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void insertar() {
        try {
            System.out.println("Entra al insertar producto");
            Conexion conexion = new Conexion();
            Statement st = conexion.conectar();
            st.executeUpdate("INSERT INTO `detalle` (`idDetalle`, `subtotalDetalle`, `cantidadDetalle`, `Producto_idProducto`, `Factura_idFactura`)"
                    + " VALUES(null, '" + getSubtotalDetalle() + "', '" + getCantidadDetalle() + "', '" + getIdProducto() + "', '" + getIdFactura() + "')");

            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}