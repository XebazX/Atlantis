/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebas
 */
public class Factura {
    int idFactura;
    String fechaFactura;
    int totalFactura;
    int idCliente;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(int totalFactura) {
        this.totalFactura = totalFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public void insertar() {
        try {
            Conexion conexion = new Conexion();
            Statement st = conexion.conectar();
            st.executeUpdate("INSERT INTO `factura` (`idFactura`, `fechaFactura`, `subtotalFactura`, `cliente_idcliente`)"
                    + " VALUES(null, NOW(), '" + getTotalFactura() + "', '" +  getIdCliente() + "')",Statement.RETURN_GENERATED_KEYS);
            
            ResultSet generatedKeys = st.getGeneratedKeys();
            System.out.println("key ....."+generatedKeys);
                if (generatedKeys.next()) {
                    // Obtener el ID del registro insertado
                    int idGenerado = generatedKeys.getInt(1);
                    setIdFactura(idGenerado);
                    System.out.println("Se ha insertado el registro con ID autogenerado: " + idGenerado);
                } else {
                    System.out.println("No se pudo obtener el ID del registro insertado.");
                }
            
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

