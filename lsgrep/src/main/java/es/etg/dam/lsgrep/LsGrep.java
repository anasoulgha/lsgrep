package es.etg.dam.lsgrep;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class LsGrep {

    public static void main(String[] args) throws IOException {
        ejecutarComandos("ls", "grep a");
    }

    public static void ejecutarComandos(String comando1, String comando2) throws IOException {
        String linea;

        Process proceso1 = Runtime.getRuntime().exec(comando1);
        Process proceso2 = Runtime.getRuntime().exec(comando2);

        BufferedReader br1 = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
        OutputStream out2 = proceso2.getOutputStream();
        PrintWriter pw2 = new PrintWriter(new OutputStreamWriter(out2));

        while ((linea = br1.readLine()) != null) {
            pw2.println(linea);
        }

        br1.close();
        pw2.close();

        BufferedReader brSalidaGrep = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
        while ((linea = brSalidaGrep.readLine()) != null) {
            System.out.println(linea);
        }

        brSalidaGrep.close();

    }
}
