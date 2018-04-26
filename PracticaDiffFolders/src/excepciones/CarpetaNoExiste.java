/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.io.File;

/**
 *
 * @author mati
 */
public class CarpetaNoExiste extends Exception {

    /**
     * Creates a new instance of <code>GestioFitxersException</code> without
     * detail message.
     */
    File c;
    File c2;

    public CarpetaNoExiste(File c, File c2) {
        this.c = c;
        this.c2 = c2;
    }
    
    
    

    @Override
    public String toString() {
        return "Las carpetas"+c.getName()+" "+c2.getName()+"no existe";
    }
    

    /**
     * Constructs an instance of <code>GestioFitxersException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    
}
