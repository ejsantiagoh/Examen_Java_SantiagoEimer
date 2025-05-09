/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen_java.cliente;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author camper
 */


public class ClienteView {
    private final Scanner scanner = new Scanner(System.in);

    public Cliente mostrarFormularioRegistro() {
        try {
            System.out.println("Ingrese ID:");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese Nombre:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese Representante:");
            String representante = scanner.nextLine();
            System.out.println("Ingrese Correo:");
            String correo = scanner.nextLine();
            System.out.println("Ingrese Teléfono:");
            String telefono = scanner.nextLine();
            System.out.println("Ingrese Dirección:");
            String direccion = scanner.nextLine();
            System.out.println("Ingrese Sector (TECNOLOGIA, SALUD, EDUCACION, COMERCIO, MANUFACTURA):");
            String sectorStr = scanner.nextLine().toUpperCase();
            Sector sector = Sector.valueOf(sectorStr); // Esto lanza IllegalArgumentException si el sector no existe
            return new Cliente(id, nombre, representante, correo, telefono, direccion, sector);
        } catch (IllegalArgumentException e) {
            System.err.println("Sector inválido. Debe ser uno de: TECNOLOGIA, SALUD, EDUCACION, COMERCIO, MANUFACTURA");
            return null; // Indica que el registro falló
        } catch (Exception e) {
            System.err.println("Error al registrar cliente: " + e.getMessage());
            return null;
        }
    }

    public void mostrarClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Lista de Clientes:");
            clientes.forEach(System.out::println);
        }
    }
}