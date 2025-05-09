/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.examen_java;

import com.examen_java.cliente.ClienteController;
import com.examen_java.cliente.ClienteDAO;
import com.examen_java.cliente.ClienteView;
import com.examen_java.database.DatabaseConnection;

import java.util.Scanner;


        /**
        String host = "jdbc:mysql://localhost:3306/";
        String user = "campus2023";
        String password = "campus2023";
        String db = "soluciones_eficientes";
        String cadConex = host + db;

        try (Connection c = DriverManager.getConnection(cadConex, user, password);) {
            System.out.println("Conexión Exitosa");
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
         */
/**
 *
 * @author camper
 */

public class Examen_Java {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ClienteController clienteController = new ClienteController(new ClienteDAO(), new ClienteView());
    private static final DatabaseConnection db = DatabaseConnection.getInstance();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Soluciones Eficientes S.A.S.");
            System.out.println("****************");
            System.out.println("       MENU     ");
            System.out.println("**************\n");

            System.out.print("""
                    1. Gestión de clientes
                    2. Gestión de servicios
                    3. Gestión de contratos
                    4. Gestión de proyectos
                    5. Gestión de empleados
                    6. Reportes
                    7. Salir

                    Elija una opción [1, 7]: """);

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar 

            switch (opcion) {
                case 1:
                    gestionarClientes();
                    break;
                case 2:
                    System.out.println("Gestión de servicios.");
                    break;
                case 3:
                    System.out.println("Gestión de contratos.");
                    break;
                case 4:
                    System.out.println("Gestión de proyectos.");
                    break;
                case 5:
                    System.out.println("Gestión de empleados.");
                    break;
                case 6:
                    System.out.println("Reportes en proceso.");
                    break;
                case 7:
                    salir = true;
                    db.closeConnection();
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void gestionarClientes() {
        boolean volver = false;
        while (!volver) {
            System.out.print("""
                    1. Registrar cliente
                    2. Listar clientes
                    3. Volver al menú principal

                    Elija una opción [1, 3]: """);

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    clienteController.registrarCliente();
                    break;
                case 2:
                    clienteController.listarClientes();
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}