package com.example.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "producto")
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column( name = "nombre" )
  private String nombre;

  @Column( name = "precio" )
  private int precio;

  @Column( name = "cantidadEnStock" )
  private int cantidadEnStock;

  public Long getId() {
    return id;
  }
  
  public void setId( Long id ) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre( String nombre ) {
    this.nombre = nombre;
  }

  public int getPrecio() {
    return precio;
  }

  public void setPrecio( int precio) {
    this.precio = precio;
  }

  public int getCantidadEnStock() {
    return cantidadEnStock;
  }

  public void setCantidadEnStock( int cantidadEnStock ) {
    this.cantidadEnStock = cantidadEnStock;
  }
}
