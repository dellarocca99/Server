package repositorio;

import modeloInfo.InfoCliente;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class EstrategiaPorCategoria extends EstrategiaProxCliente{
    @Override
    public InfoCliente proximoCliente() {
        int categoria =0;
        boolean ok;
        InfoCliente infoCliente=null;
        do {
            try {
                categoria++;
                ok=true;
                int finalCategoria = categoria;
                Predicate<InfoCliente> predicado = new Predicate<InfoCliente>() {
                    @Override
                    public boolean test(InfoCliente infoCliente) {
                        return (infoCliente.getCategoria() == finalCategoria);
                    }
                };
                infoCliente = this.colaClientes.stream()
                        .filter(predicado).findFirst().get();
            } catch (NoSuchElementException e) {
                ok=false;
            }
        }while (ok==false);
        return infoCliente;
    }
}
