
package edd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prueba {
    public static void main(String[] args) throws FileNotFoundException {
        String nombre = "";
        int noPersonas = 0;
        int tiempoMilitar = 0;
        int minutosActiva = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("./estructuras/lineales/restaurante.txt"));

            // leer la primera línea y crear el array de números
            String primeraLinea = br.readLine();
            String[] numerosString = primeraLinea.split(",");
            int[] numeros = new int[numerosString.length];
            for (int i = 0; i < numerosString.length; i++) {
                numeros[i] = Integer.parseInt(numerosString[i]);
            }

            // procesar las líneas restantes y crear los objetos
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(" ");
                nombre = campos[0];
                noPersonas = Integer.parseInt(campos[1]);
                tiempoMilitar = Integer.parseInt(campos[2]);
                minutosActiva = Integer.parseInt(campos[3]);

                Reservacion reservacion = new Reservacion(nombre, noPersonas, tiempoMilitar, minutosActiva);
                System.out.println();
                System.out.println("Nombre: " + reservacion.nombre);
                System.out.println("Número de personas: " + reservacion.noPersonas);
                System.out.println("Tiempo militar de entrada: " + reservacion.tiempoMilitar);
                System.out.println("Minutos activa: " + reservacion.minutosActiva);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}