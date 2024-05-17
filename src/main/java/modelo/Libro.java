/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
        
public class Libro {
    private int ISBN;
    private String titulo;
    private String autor;
    private String anioPublicacion;
    private String editorial;
    private int cantidadDisponible;
}
