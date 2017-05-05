/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.*;

/**
 *
 * @author ivan
 */
public class Clonar {

    public static void clonar() {
        try {
            File inFile = new File("ingredeintes.txt");
            File outFile = new File("IngComp.txt");

            InputStream in = new FileInputStream(inFile);
            OutputStream out = new FileOutputStream(outFile);

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println("Hubo un error de entrada/salida!!!");
        }
    }
}
