/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;

/**
 *
 * @author kinch
 */
public interface CrudInterface<T> {

    void executeCreate(T object);

    public List<T> leerTodo();

    public void actualizar(T object);

    public void eliminar(int id);

    public void buscarPorId(int id);

}
