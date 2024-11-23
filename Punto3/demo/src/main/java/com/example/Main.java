package com.example;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.example.entidad.Producto;

import javax.persistence.EntityManagerFactory;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
    public static void main(String[] args) {
        // crearProduto("Computador", 1000000, 10);
        Producto producto = leerProducto(2L);
        if( producto != null ) {
            System.out.println("Producto: " + producto.getNombre());
        } else {
            System.out.println("El producto no existe");
        }
    }

    public static void crearProduto( String nombre, int precio, int cantidadEnStock ) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidadEnStock(cantidadEnStock);

        em.persist(producto);
        em.getTransaction().commit();
        em.close();
    }

    public static Producto leerProducto( Long id ) {
        EntityManager em = emf.createEntityManager();

        Producto producto = em.find(Producto.class, id);
        em.close();

        return producto;
    }
}