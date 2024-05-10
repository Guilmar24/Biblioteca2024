/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobiblioteca;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
        
public class Prestamo {
    private int identificacion;
    private int usuarioId;
    private int libroIsbn;
    private int fechaPrestamo;
    private int fechaVencimiento;
    private int fechaDevolucion;
    private int multa;
}
