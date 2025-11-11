package psp.practica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class NumRandom {

    public static void generarNum(){
        Random random = new Random();
        File archivo = new File("temp.txt");

        try{
            if(archivo.exists()){
                archivo.delete();
            }
            archivo.createNewFile();
        } catch (Exception e){
            e.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("temp.txt")))){

            bw.write(String.valueOf(random.nextInt(10)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generarNum();
    }

}
