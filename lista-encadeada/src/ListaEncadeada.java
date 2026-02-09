public class ListaEncadeada<T> {

    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public boolean isEmpty() {
        return referenciaEntrada == null ? true : false;
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);
        if (this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;
        }
        No<T> referenciaAuxiliar = referenciaEntrada; //variável auxiliar para percorrer a lista
        for (int i = 0; i < this.size() - 1; i++) {
            referenciaAuxiliar = referenciaAuxiliar.getProximoNo(); //percorre a lista até o último nó
        }
        referenciaAuxiliar.setProximoNo(novoNo);
    }

    public int size() {
        int tamanhoLista = 0;
        No<T> referenciaAuxiliar = referenciaEntrada;
        while (true) {
            if (referenciaAuxiliar != null) {
                tamanhoLista++;
                if (referenciaAuxiliar.getProximoNo() != null) {
                    referenciaAuxiliar = referenciaAuxiliar.getProximoNo(); 
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return tamanhoLista;
    }

}
