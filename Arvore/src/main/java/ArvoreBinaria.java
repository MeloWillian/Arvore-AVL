public class ArvoreBinaria {
    private No raiz = null;

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No noAtual, int valor) {
        if (noAtual == null) {
            return new No(valor);
        }

        if (valor < noAtual.valor) {
            noAtual.filhoEsquerdo = inserirRecursivo(noAtual.filhoEsquerdo, valor);
        } else if (valor > noAtual.valor) {
            noAtual.filhoDireito = inserirRecursivo(noAtual.filhoDireito, valor);
        }

        return noAtual;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No noAtual, int valor) {
        if (noAtual == null) return false;
        if (valor == noAtual.valor) return true;

        if (valor < noAtual.valor) {
            return buscarRecursivo(noAtual.filhoEsquerdo, valor);
        } else {
            return buscarRecursivo(noAtual.filhoDireito, valor);
        }
    }

    public No capturarNo(int valor) {
        return capturarNoRecursivo(raiz, valor);
    }

    private No capturarNoRecursivo(No noAtual, int valor) {
        if (noAtual == null) return null;
        if (valor == noAtual.valor) return noAtual;

        if (valor < noAtual.valor) {
            return capturarNoRecursivo(noAtual.filhoEsquerdo, valor);
        } else {
            return capturarNoRecursivo(noAtual.filhoDireito, valor);
        }
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No noAtual, int valor) {
        if (noAtual == null) return null;

        if (valor < noAtual.valor) {
            noAtual.filhoEsquerdo = removerRecursivo(noAtual.filhoEsquerdo, valor);
        } else if (valor > noAtual.valor) {
            noAtual.filhoDireito = removerRecursivo(noAtual.filhoDireito, valor);
        } else {
            if (noAtual.filhoEsquerdo == null) {
                return noAtual.filhoDireito;
            }
            if (noAtual.filhoDireito == null) {
                return noAtual.filhoEsquerdo;
            }

            noAtual.valor = encontrarMenorValor(noAtual.filhoDireito);
            noAtual.filhoDireito = removerRecursivo(noAtual.filhoDireito, noAtual.valor);
        }

        return noAtual;
    }

    private int encontrarMenorValor(No noAtual) {
        while (noAtual.filhoEsquerdo != null) {
            noAtual = noAtual.filhoEsquerdo;
        }
        return noAtual.valor;
    }

    public void imprimirPreOrdem() {
        imprimirPreOrdemRecursivo(raiz);
        System.out.println(); // Para pular a linha após a impressão
    }

    private void imprimirPreOrdemRecursivo(No noAtual) {
        if (noAtual != null) {
            System.out.print(noAtual.valor + " ");
            imprimirPreOrdemRecursivo(noAtual.filhoEsquerdo);
            imprimirPreOrdemRecursivo(noAtual.filhoDireito);
        }
    }

    public void imprimirPosOrdem() {
        imprimirPosOrdemRecursivo(raiz);
        System.out.println(); // Para pular a linha após a impressão
    }

    private void imprimirPosOrdemRecursivo(No noAtual) {
        if (noAtual != null) {
            imprimirPosOrdemRecursivo(noAtual.filhoEsquerdo);
            imprimirPosOrdemRecursivo(noAtual.filhoDireito);
            System.out.print(noAtual.valor + " ");
        }
    }
    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
        System.out.println(); // Para pular a linha após a impressão
    }

    private void imprimirEmOrdemRecursivo(No noAtual) {
        if (noAtual != null) {
            imprimirEmOrdemRecursivo(noAtual.filhoEsquerdo);
            System.out.print(noAtual.valor + " ");
            imprimirEmOrdemRecursivo(noAtual.filhoDireito);
        }
    }
    public int altura(No noAtual){
        int esq =-1;
        int dir = -1;
        if(noAtual == null) return -1;
        esq = altura(noAtual.filhoEsquerdo);
        dir = altura(noAtual.filhoDireito);
        return Math.max(esq,dir) + 1;
    }
}
