package modeloInfo;

import java.util.Date;

public class FactoryInfoCliente {
    public static InfoCliente getPaqueteNuevoCliente(int dni, Date fechaYHoraRegistro){
        return new InfoCliente(dni,fechaYHoraRegistro);
    }
}
