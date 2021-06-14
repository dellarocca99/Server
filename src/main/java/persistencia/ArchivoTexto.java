package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modeloInfo.InfoClienteAtendido;

public class ArchivoTexto implements Persistor,Buscador {

    @Override
    public void persistir(InfoClienteAtendido infoCliente) {
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\feder\\OneDrive\\Documentos\\4to año\\Análisis y Diseño de Sistemas 2\\Server\\src\\main\\resources\\registros.txt",true));
            bw.append(infoCliente.toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String buscarNombre(Integer dni) {
        String nombre = null;
        String datos = "";
        String[] datosSeparados;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\feder\\OneDrive\\Documentos\\4to año\\Análisis y Diseño de Sistemas 2\\Server\\src\\main\\resources\\repositorio.txt"));
            datos = br.readLine();
            while(datos!=null && nombre == null) {
                //Tenemos los datos del "Repositorio separados por -"
                datosSeparados = datos.split("-");
                //La posicion 0 de los datos corresponde al nombre, la 1 al dni y la 2 a la categoria.
                if(Integer.valueOf(datosSeparados[1]) == dni)
                    nombre = datosSeparados[0];
                datos = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombre;
    }

    @Override
    public String[] buscaCategoriaYNombre(Integer dni) {
        String[] infoCliente = null;
        String datos = "";
        String[] datosSeparados=null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\feder\\OneDrive\\Documentos\\4to año\\Análisis y Diseño de Sistemas 2\\Server\\src\\main\\resources\\repositorio.txt"));
            datos = br.readLine();
            while(datos!=null && infoCliente == null) {
                //Tenemos los datos del "Repositorio separados por -"
                datosSeparados = datos.split("-");
                //La posicion 1 de los datos corresponde al nombre, la 2 al dni y la 3 a la categoria.
                if(Integer.parseInt(datosSeparados[1]) == dni) {
                    infoCliente = new String[2];
                    //En la posicion 0 le pongo el nombre.
                    infoCliente[0] = datosSeparados[0];
                    //En la posicion 1 le pongo la categoria.
                    infoCliente[1] = datosSeparados[2];
                }
                datos = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return infoCliente;
    }

}