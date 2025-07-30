public class ArvoreBinaria {
    private No raiz = null;

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No noAtual, int valor) {
        if (noAtual == null) {
            return new No(valor);
        }

        if (valor < noAtual.getValor()) {
            noAtual.setFilhoEsquerdo(inserirRecursivo(noAtual.getFilhoEsquerdo(), valor));
        } else if (valor > noAtual.getValor()) {
            noAtual.setFilhoDireito(inserirRecursivo(noAtual.getFilhoDireito(), valor));
        }

        return noAtual;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No noAtual, int valor) {
        if (noAtual == null) return false;
        if (valor == noAtual.getValor()) return true;

        if (valor < noAtual.getValor()) {
            return buscarRecursivo(noAtual.getFilhoEsquerdo(), valor);
        } else {
            return buscarRecursivo(noAtual.getFilhoDireito(), valor);
        }
    }

    public No capturarNo(int valor) {
        return capturarNoRecursivo(raiz, valor);
    }

    private No capturarNoRecursivo(No noAtual, int valor) {
        if (noAtual == null) return null;
        if (valor == noAtual.getValor()) return noAtual;

        if (valor < noAtual.getValor()) {
            return capturarNoRecursivo(noAtual.getFilhoEsquerdo(), valor);
        } else {
            return capturarNoRecursivo(noAtual.getFilhoDireito(), valor);
        }
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No noAtual, int valor) {
        if (noAtual == null) return null;

        if (valor < noAtual.getValor()) {
            noAtual.setFilhoEsquerdo(removerRecursivo(noAtual.getFilhoEsquerdo(), valor));
        } else if (valor > noAtual.getValor()) {
            noAtual.setFilhoDireito(removerRecursivo(noAtual.getFilhoDireito(), valor));
        } else {
            if (noAtual.getFilhoEsquerdo() == null) {
                return noAtual.getFilhoDireito();
            }
            if (noAtual.getFilhoDireito() == null) {
                return noAtual.getFilhoEsquerdo();
            }

            noAtual.setValor(encontrarMenorValor(noAtual.getFilhoDireito()));
            noAtual.setFilhoDireito(removerRecursivo(noAtual.getFilhoDireito(), noAtual.getValor()));
        }

        return noAtual;
    }

    private int encontrarMenorValor(No noAtual) {
        while (noAtual.getFilhoEsquerdo() != null) {
            noAtual = noAtual.getFilhoEsquerdo();
        }
        return noAtual.getValor();
    }

    public void imprimirPreOrdem() {
        imprimirPreOrdemRecursivo(raiz);
        System.out.println();
    }

    private void imprimirPreOrdemRecursivo(No noAtual) {
        if (noAtual != null) {
            System.out.print(noAtual.getValor() + " ");
            imprimirPreOrdemRecursivo(noAtual.getFilhoEsquerdo());
            imprimirPreOrdemRecursivo(noAtual.getFilhoDireito());
        }
    }

    public void imprimirPosOrdem() {
        imprimirPosOrdemRecursivo(raiz);
        System.out.println();
    }

    private void imprimirPosOrdemRecursivo(No noAtual) {
        if (noAtual != null) {
            imprimirPosOrdemRecursivo(noAtual.getFilhoEsquerdo());
            imprimirPosOrdemRecursivo(noAtual.getFilhoDireito());
            System.out.print(noAtual.getValor() + " ");
        }
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void imprimirEmOrdemRecursivo(No noAtual) {
        if (noAtual != null) {
            imprimirEmOrdemRecursivo(noAtual.getFilhoEsquerdo());
            System.out.print(noAtual.getValor() + " ");
            imprimirEmOrdemRecursivo(noAtual.getFilhoDireito());
        }
    }

    public int altura(No noAtual) {
        if (noAtual == null) return -1;
        int esq = altura(noAtual.getFilhoEsquerdo());
        int dir = altura(noAtual.getFilhoDireito());
        return Math.max(esq, dir) + 1;
    }
    public int fatorBalanceamento(No noAtual){
        return altura(noAtual.getFilhoEsquerdo()) - altura(noAtual.getFilhoDireito());
    }
}
