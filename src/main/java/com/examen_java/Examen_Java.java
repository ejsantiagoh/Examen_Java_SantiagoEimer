/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.examen_java;

import com.examen_java.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;


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

    public static void main(String[] args) {
        System.out.println("Soluciones Eficientes S.A.S.");
        System.out.println("****************");
        System.out.println("       MENU     ");
        System.out.println("**************\n");

         System.out.print("""
                             1. Gestion de clientes
                             2. Gestion de servicios
                             3. Gestion de contratos
                             4. Gestion de proyectos
                             5. Gestion de empleados
                             6. Reportes
                             7. salir

                             Eliga una opci\u00f3n [1, 7]:  """);
         
         DatabaseConnection db = new DatabaseConnection();
         db.closeConnection();
         db.getConnection();

    }
}
