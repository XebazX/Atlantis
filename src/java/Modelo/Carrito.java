/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public class Carrito {
    
    private static int total=0;
    private static final ArrayList listaProductos = new ArrayList();

    public int getTotal() {
        return total;
    }
    
    public static int getTotalfinal() {
        return total;
    }

    public void setTotal(int total) {
        Carrito.total = total;
    }
    
    public static int tamaño() {
        return listaProductos.size();
    }    
    
    public static Producto obtenerProducto(int index){
        return (Producto)listaProductos.get(index);
    }
    
    public ArrayList listar() {
        return listaProductos;
    }
    
    
    public static void insertar(Producto miP) {
        System.out.println("entra a insertar carrito");
        total = total +  miP.getPrecioProducto();
        listaProductos.add(miP);
    }
    
    public static void eliminar(Producto mP){
        listaProductos.remove(mP);
    }
    
    public static void modificar(Producto MP){
        
    }
    
}
