package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.entidad.Tienda;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        // crearTienda("D1", "Correo", 123456);
        Tienda tienda = leerTienda(6L);
        if( tienda != null ) {
            System.out.println("La tienda es: " + tienda.getNombre());
        } else {
            System.out.println("No se encontró ningun tienda");
        }
    }

    public static void crearTienda( String nombre, String email, int telefono ) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Tienda tienda = new Tienda();

        tienda.setNombre(nombre);
        tienda.setEmail(email);
        tienda.setTelefono(telefono);

        em.persist(tienda);
        em.getTransaction().commit();
        em.close();
    }


    public static Tienda leerTienda(Long id) {
        EntityManager em = emf.createEntityManager();
        Tienda tienda = em.find(Tienda.class, id);
        em.close();
        return tienda;
    }
}