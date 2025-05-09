/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen_java.cliente;

import com.examen_java.contrato.Contrato;
import com.examen_java.proyecto.EstadoProyecto;
import com.examen_java.proyecto.Proyecto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author camper
 */

public class Cliente {
    private int id;
    private String nombre;
    private String representante;
    private String correo;
    private String telefono;
    private String direccion;
    private Sector sector;
    private List<Contrato> contratos = new ArrayList<>(); // Para consultarContratos()
    private List<Proyecto> proyectos = new ArrayList<>(); // Para listarProyectosActivos()

    public Cliente() {
    }

    public Cliente(int id, String nombre, String representante, String correo, String telefono, String direccion, Sector sector) {
        this.id = id;
        this.nombre = nombre;
        this.representante = representante;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sector = sector;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<Contrato> consultarContratos() {
        return contratos;
    }

    public List<Proyecto> listarProyectosActivos() {
        return proyectos.stream()
                .filter(p -> p.getEstado() == EstadoProyecto.EN_CURSO)
                .collect(Collectors.toList());
    }

    public void agregarContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    public void agregarProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", representante='" + representante + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", sector=" + sector +
                '}';
    }
}
