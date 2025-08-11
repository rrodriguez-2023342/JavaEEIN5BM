package com.kinalitosclothes.view;

import com.kinalitosclothes.modelo.FacturasDAO;
import java.util.Scanner;

public class MenuFacturas {

    public void MenuFacturas() {
        Scanner leer = new Scanner(System.in);
        int op = 1;
        FacturasDAO fc = new FacturasDAO();
        while (op != 0) {
            System.out.println("-----------------------------------");
            System.out.println("Bienvenido al menu de Facturas");
            System.out.println("Por favor elija una opcion:");
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Eliminar");
            System.out.println("4. Buscar");
            System.out.println("5. Editar");
            System.out.println("0. Salir");
            System.out.println("-----------------------------------");
            op = leer.nextInt();
            switch (op) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;  
                case 5:
                    
                    break;
                case 0:
                    
                    break;
                default:
                    System.out.println("Por favor seleecione una de las opciones validas");
            }
        }

    }
}
