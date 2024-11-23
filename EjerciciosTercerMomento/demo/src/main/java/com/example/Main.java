package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.entidad.Libro;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        // crearLibro("Metafisica", "Conny Mendez", 2012);
        // eliminarLibro(2L);
        actualizarLibro(1L, "Metafisica 4 en 1", "Conny");
                
    }

    public static void crearLibro( String titulo, String autor, int anioPublicacion ) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setAnioPublicacion(anioPublicacion);

        em.persist(libro);
        em.getTransaction().commit();
        em.close();
    }

    public static void actualizarLibro(Long id, String nuevoTitulo, String nuevoAutor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, id);
        if (libro != null) {
            libro.setTitulo(nuevoTitulo);
            libro.setAutor(nuevoAutor);
            em.merge(libro);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void eliminarLibro(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, id);
        if (libro != null) {
            em.remove(libro);
        }
        em.getTransaction().commit();
        em.close();
    }
}