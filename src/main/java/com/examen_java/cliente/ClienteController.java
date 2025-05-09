/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen_java.cliente;

/**
 *
 * @author camper
 */


public class ClienteController {
    private final ClienteDAO clienteDAO;
    private final ClienteView clienteView;

    public ClienteController(ClienteDAO clienteDAO, ClienteView clienteView) {
        this.clienteDAO = clienteDAO;
        this.clienteView = clienteView;
    }

    public void registrarCliente() {
        Cliente cliente = clienteView.mostrarFormularioRegistro();
        if (cliente != null) {
            clienteDAO.registrarCliente(cliente);
        } else {
            System.out.println("Registro cancelado debido a un error en los datos.");
        }
    }

    public void listarClientes() {
        clienteView.mostrarClientes(clienteDAO.listarClientes());
    }
}