package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modeloInfo.InfoClienteAtendido;

public class PersistenciaTexto implements Persistor,Buscador {

    @Override
    public void persistir(InfoClienteAtendido infoCliente) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("registros.txt"));
            bw.write(infoCliente.toString());
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
            BufferedReader br = new BufferedReader(new FileReader("repositorio.txt"));
            while(br.ready() && nombre == null) {
                datos = br.readLine();
                //Tenemos los datos del "Repositorio separados por -"
                datosSeparados = datos.split("-");
                //La posicion 0 de los datos corresponde al nombre, la 1 al dni y la 2 a la categoria.
                if(Integer.valueOf(datosSeparados[1]) == dni)
                    nombre = datosSeparados[0];
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
        String[] datosSeparados;
        try {
            BufferedReader br = new BufferedReader(new FileReader("repositorio.txt"));
            while(br.ready() && infoCliente == null) {
                datos = br.readLine();
                //Tenemos los datos del "Repositorio separados por -"
                datosSeparados = datos.split("-");
                //La posicion 1 de los datos corresponde al nombre, la 2 al dni y la 3 a la categoria.
                if(Integer.valueOf(datosSeparados[1]) == dni) {
                    infoCliente = new String[2];
                    //En la posicion 0 le pongo el nombre.
                    infoCliente[0] = datosSeparados[0];
                    //En la posicion 1 le pongo la categoria.
                    infoCliente[1] = datosSeparados[2];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return infoCliente;
    }

}