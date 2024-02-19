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
public class Cliente {

    public static Cliente getClienteIniciado() {
        return ClienteIniciado;
    }

    public static void setClienteIniciado(Cliente aClienteIniciado) {
        ClienteIniciado = aClienteIniciado;
    }

    private int idCliente;
    private String nombreCliente;
    private String documentoCliente;
    private String direccionCliente;
    private String celularCliente;
    private int paginacion = 10;
    private static Cliente ClienteIniciado;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public int getPaginacion() {
        return paginacion;
    }

    public void setPaginacion(int paginacion) {
        this.paginacion = paginacion;
    }
    
    

    public ArrayList Listar(int pagina) {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaClientes = new ArrayList();
        Cliente elCliente;
        String listado = "SELECT * FROM cliente" + " ORDER BY idcliente";

        if (pagina > 0) {
            int paginacionMax = pagina * this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            listado = " SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idcliente LIMIT " + paginacionMin + " , " + paginacionMax;
        }
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {
                elCliente = new Cliente();
                elCliente.setIdCliente(rs.getInt("idcliente"));
                elCliente.setNombreCliente(rs.getString("nombreCliente"));
                elCliente.setDocumentoCliente(rs.getString("documentoCliente"));
                elCliente.setDireccionCliente(rs.getString("direccionCliente"));
                elCliente.setCelularCliente(rs.getString("celularCliente"));
                listaClientes.add(elCliente);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar Cliente:" + ex.getLocalizedMessage());
        } finally {
            conexion.desconectar();
        }
        return listaClientes;

    }

    public void Insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        System.out.println("1a");
        try {
            st.executeUpdate("INSERT INTO cliente (idcliente, nombreCliente, documentoCliente, direccionCliente, celularCliente)" + "VALUES(" + getIdCliente() + ",' " + getNombreCliente() + "', '" + getDocumentoCliente() + "', '" + getDireccionCliente() + "', '" + getCelularCliente() + "')");

        } catch (SQLException ex) {
            System.err.println("Error al insertar Cliente:" + ex.getLocalizedMessage());
        } finally {
            conexion.desconectar();
        }

    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE cliente SET nombreCliente='" + getNombreCliente() + "', documentoCliente='" + getDocumentoCliente() + "', direccionCliente='" + getDireccionCliente() + "', celularCliente='" + getCelularCliente() + "' WHERE idcliente=" + getIdCliente());

        } catch (SQLException ex) {

            System.err.println("Error al modificar el Cliente:" + ex.getLocalizedMessage());
        }   finally {
            conexion.desconectar();
        }

    }

    public void Eliminar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("DELETE FROM cliente WHERE idcliente =" + getIdCliente());
        } catch (SQLException ex) {
            System.err.println("Error al eliminar el Cliente: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public int cantidadPaginas() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL (COUNT(idcliente)/" + this.paginacion + ") AS cantidad FROM ");
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de Clientes" + ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }

    public boolean InicioSesionCliente(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        Cliente cliente = new Cliente();
        try{
           String con1 = "SELECT * FROM " +this.getClass().getSimpleName()+" WHERE nombreCliente LIKE '%"+getNombreCliente()+"%' AND documentoCliente  LIKE '"+getDocumentoCliente()+"'";
           System.out.println("consulta------    "+con1);
           ResultSet rs = st.executeQuery(con1);
            
            
            
            if (rs.next()){
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNombreCliente(rs.getString("nombreCliente"));
                cliente.setDocumentoCliente(rs.getString("documentoCliente"));
                Cliente.setClienteIniciado(cliente);
                System.out.println( "Inicio Correctamente");
                return true; 
            }
        }catch (SQLException ex) {
            System.err.println("Error en iniciar sesion " + ex);
        }
        return false;
}
    
}
