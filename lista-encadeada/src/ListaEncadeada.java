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

    private No<T> getNo(int index) {
        validaIndice(index);
        No<T> referenciaAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;
        for (int i = 0; i <= index; i++) {
            noRetorno = referenciaAuxiliar;
            referenciaAuxiliar = referenciaAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    public int size() {
        int tamanhoLista = 0;
        No<T> referenciaAuxiliar = referenciaEntrada;
        while (true) {
            if (referenciaAuxiliar != null) {
                tamanhoLista++;
                if (referenciaAuxiliar.getProximoNo() != null) { //verifica se o próximo nó é nulo, se não for, continua percorrendo a lista
                    referenciaAuxiliar = referenciaAuxiliar.getProximoNo(); //percorre a lista
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return tamanhoLista;
    }

    private void validaIndice(int index) {
        if (index >= size()) {
            int ultimoIndice = size() - 1; //o último índice é o tamanho da lista - 1, pois o índice começa em 0
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + " desta lista. Esta lista só tem conteúdo até o índice " + ultimoIndice + ".");
        }
    }

}
