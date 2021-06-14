package modeloInfo;

public class FactoryInfoClienteAtendido {
    public static InfoClienteAtendido getInfoClienteAtendido(InfoCliente infoCliente, int box){
        return new InfoClienteAtendido(infoCliente,box);
    }
}
