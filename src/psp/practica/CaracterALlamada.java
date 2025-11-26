package psp.practica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class CaracterALlamada {

    public void transformar(String linea){

        ProcessBuilder pb;
        Process process;

        if (!linea.isEmpty()) {

            String classname = "psp.practica1.NumRandom";
            String currentPath = System.getProperty("user.dir");
            String classpath = currentPath + "/out/production/PalabraNumRandom/";

            try{

                pb = new ProcessBuilder("java", "-cp", classpath, classname);
                pb.inheritIO();

                for (int i = 0; i < linea.length(); i++) {

                    if ( !linea.toLowerCase().equals("fin")) {
                        process = pb.start();
                        process.waitFor();

                        try (BufferedReader br = new BufferedReader(new FileReader(new File("temp.txt")))){
                            String line;
                            while ((line = br.readLine()) != null){
                                System.out.print(line);
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        CaracterALlamada caracterALlamada = new CaracterALlamada();
        Scanner teclado = new Scanner(System.in);
        String linea = "";

        do{

            System.out.println("\nIntroduce por teclado una linea y \"Fin\" para acabar:");
            linea = teclado.nextLine();
            caracterALlamada.transformar(linea);

        } while(!(linea.toLowerCase().equals("fin")));

    }

}
