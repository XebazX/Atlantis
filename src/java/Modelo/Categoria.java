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
public class Categoria {
    private int idCategoria;
    private String nombreCategoria;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "nombreCategoria=" + nombreCategoria + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Categoria other = (Categoria) obj;
        return this.idCategoria == other.idCategoria;
    }
    
     public ArrayList Listar(int pagina) {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaCategorias = new ArrayList();
        Categoria laCategoria;
        String listado = "SELECT * FROM Categoria" + " ORDER BY idCategoria";

        
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {
                laCategoria = new Categoria();
                laCategoria.setIdCategoria(rs.getInt("idCategoria"));
                laCategoria.setNombreCategoria(rs.getString("nombreCategoria"));
                System.out.println(laCategoria.getIdCategoria()+laCategoria.getNombreCategoria());
                listaCategorias.add(laCategoria);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar la Categoria :" + ex.getLocalizedMessage());
        } finally {
            conexion.desconectar();
        }
         System.out.println(listaCategorias);
        return listaCategorias;

    }

    public void Insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            String catt = "INSERT INTO Categoria (idCategoria, nombreCategoria)" + "VALUES(" + getIdCategoria()+ ", '" + getNombreCategoria()+ "')";
            System.out.println(catt);
            st.executeUpdate(catt);

        } catch (SQLException ex) {
            System.err.println("Error al insertar la Categoria:" + ex.getLocalizedMessage());
        } finally {
            conexion.desconectar();
        }

    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE Categoria SET nombreCategoria='" + getNombreCategoria()+  "' WHERE idCategoria=" + getIdCategoria());

        } catch (SQLException ex) {

            System.err.println("Error al modificar la Categoria:" + ex.getLocalizedMessage());
        }   finally {
            conexion.desconectar();
        }

    }

    public void Eliminar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            String ell = "DELETE FROM Categoria WHERE idCategoria=" + getIdCategoria();
            System.out.println(ell);
            st.executeUpdate(ell);
        } catch (SQLException ex) {
            System.err.println("Error al eliminar la Categoria: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    


}
