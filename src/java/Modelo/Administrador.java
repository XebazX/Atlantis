/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class Administrador {

    private int idAdministrador;
    private String ContraseñaAdm;
    private String CorreoAdm;
    private static Administrador AdministradorIniciado;

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getContraseñaAdm() {
        return ContraseñaAdm;
    }

    public void setContraseñaAdm(String ContraseñaAdm) {
        this.ContraseñaAdm = ContraseñaAdm;
    }

    public String getCorreoAdm() {
        return CorreoAdm;
    }

    public void setCorreoAdm(String CorreoAdm) {
        this.CorreoAdm = CorreoAdm;
    }
    
    public static Administrador getAdministradorIniciado() {
        return AdministradorIniciado;
    }

    public static void setAdministradorIniciado(Administrador AdministradorIniciado) {
        Administrador.AdministradorIniciado = AdministradorIniciado;
    }



    public ArrayList Listar(int pagina) {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaAdministradores = new ArrayList();
        Administrador elAdministrador;
        String listado = "SELECT * FROM Administrador" + " ORDER BY idAdministrador";

        
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {
                elAdministrador = new Administrador();
                elAdministrador.setIdAdministrador(rs.getInt("idAdministrador"));
                elAdministrador.setCorreoAdm(rs.getString("CorreoAdm"));
                elAdministrador.setContraseñaAdm(rs.getString("ContraseñaAdm"));

                listaAdministradores.add(elAdministrador);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar Administrador:" + ex.getLocalizedMessage());
        } finally {
            conexion.desconectar();
        }
        return listaAdministradores;

    }

    public void Insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
       
        try {
            st.executeUpdate("INSERT INTO Administrador (idAdministrador, CorreoAdm, ContraseñaAdm)" + "VALUES(" + getIdAdministrador() + ",' " + getCorreoAdm() + "', '" + getContraseñaAdm() + "')");

        } catch (SQLException ex) {
            System.err.println("Error al insertar Administrador:" + ex.getLocalizedMessage());
        } finally {
            conexion.desconectar();
        }

    }
    
    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE Administrador SET CorreoAdm='" + getCorreoAdm()+ "', ContraseñaAdm='" + getContraseñaAdm()+ "' WHERE idAdministrador=" + getIdAdministrador());

        } catch (SQLException ex) {

            System.err.println("Error al modificar el Administrador:" + ex.getLocalizedMessage());
        }   finally {
            conexion.desconectar();
        }

    }

    public void Eliminar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("DELETE FROM Administrador WHERE idAdministrador =" + getIdAdministrador());
        } catch (SQLException ex) {
            System.err.println("Error al eliminar el Administrador: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

   

    public boolean InicioSesionAdministrador(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        Administrador Administrador = new Administrador();
        try{
           String con = "SELECT * FROM " +this.getClass().getSimpleName()+" WHERE correoAdm LIKE "+getCorreoAdm()+" AND contraseñaAdm  LIKE CONVERT(sha2("+getContraseñaAdm()+ ", 256), CHAR(32))";
           String con1 = "SELECT * FROM " +this.getClass().getSimpleName()+" WHERE correoAdm LIKE '%"+getCorreoAdm()+"%' AND contraseñaAdm  LIKE '"+getContraseñaAdm()+"'";
           System.out.println("consulta------    "+con1);
           ResultSet rs = st.executeQuery(con1);
            
            
            
            if (rs.next()){
                Administrador.setIdAdministrador(rs.getInt("idAdministrador"));
                Administrador.setCorreoAdm(rs.getString("correoADM"));
                Administrador.setContraseñaAdm(rs.getString("contraseñaADM"));
                Administrador.setAdministradorIniciado(Administrador);
                System.out.println( "Inicio Correctamente");

                return true; 
            }
        }catch (SQLException ex) {
            System.err.println("Error en iniciar sesion " + ex);
        }
        return false;
}
}
