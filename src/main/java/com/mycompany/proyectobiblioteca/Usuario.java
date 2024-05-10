/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobiblioteca;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
        
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String username;
    private String password;
    private int idRole;
}
