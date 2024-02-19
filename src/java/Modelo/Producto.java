/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public class Producto {

    private int idProducto;
    private String nombreProducto;
    private String detalleProducto;
    private int precioProducto;
    private String stockProducto;
    private int Categoria;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(String detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(String stockProducto) {
        this.stockProducto = stockProducto;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombreProducto=" + nombreProducto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.idProducto == other.idProducto;
    }

    public ArrayList Listar(int pagina) {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaProductos = new ArrayList();
        Producto elProducto;
        String listado = "SELECT * FROM Producto" + " ORDER BY idProducto";
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {
                elProducto = new Producto();
                elProducto.setIdProducto(rs.getInt("idProducto"));
                elProducto.setNombreProducto(rs.getString("nombreProducto"));
                elProducto.setDetalleProducto(rs.getString("detalleProducto"));
                elProducto.setPrecioProducto(rs.getInt("precioProducto"));
                elProducto.setStockProducto(rs.getString("stockProducto"));
                elProducto.setCategoria(rs.getInt("Categoria_idCategoria"));
                
                System.out.println(elProducto); 
                
                listaProductos.add(elProducto);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar el Producto:" + ex.getLocalizedMessage());
        } finally {
            conexion.desconectar();
        }
        return listaProductos;

    }

    public void Insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();

        try {
            String catte = "INSERT INTO Producto (idProducto, nombreProducto, detalleProducto, precioProducto, stockProducto, Categoria_idCategoria)" + "VALUES(" + getIdProducto() + ",' " + getNombreProducto() + "', '" + getDetalleProducto() + "', '" + getPrecioProducto() + "', '" + getStockProducto() + "','" + getCategoria() + "')";
            System.out.println(catte);
            st.executeUpdate(catte);
        } catch (SQLException ex) {
            System.err.println("Error al insertar Producto:" + ex.getLocalizedMessage());
        } finally {
            conexion.desconectar();
        }

    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE Producto SET nombreProducto='" + getNombreProducto() + "', detalleProducto='" + getDetalleProducto() + "', PrecioProducto='" + getPrecioProducto() + "', stockProducto='" + getStockProducto() + "', Categoria_idCategoria='" + getCategoria() + "' WHERE idProducto=" + getIdProducto());

        } catch (SQLException ex) {

            System.err.println("Error al modificar el Producto:" + ex.getLocalizedMessage());
        } finally {
            conexion.desconectar();
        }

    }

    public void Eliminar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("DELETE FROM Producto WHERE idProducto =" + getIdProducto());
        } catch (SQLException ex) {
            System.err.println("Error al eliminar el Producto: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

 

    
 
}
