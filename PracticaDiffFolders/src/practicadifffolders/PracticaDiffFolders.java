/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicadifffolders;

import excepciones.CarpetaNoExiste;
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class PracticaDiffFolders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File carpeta1, carpeta2;
        String carp1, carp2;
        Iterator<ResultatComparacio> it = null;

        try {
            // TODO code application logic here

            System.out.println("Introduce la ruta 1");
            carp1 = teclado.nextLine();
            carpeta1 = new File(carp1);
            System.out.println("Introduce la ruta 2");
            carp2 = teclado.nextLine();
            carpeta2 = new File(carp2);
            DiffFolder difFol = new DiffFolder();
            
            difFol.setFolders(carpeta1, carpeta2);
            it = difFol.compare();
            System.out.println("\t NOMBRE FICHERO" + "\t VALOR RESULTADO");
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        } catch (GestioFitxersException ex) {
            System.out.println(ex.toString());
        } catch (CarpetaNoExiste ex) {
            System.out.println(ex.toString());
        }

    }

}
