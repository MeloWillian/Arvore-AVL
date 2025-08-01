public class ArvoreBinaria {
    public No raiz = null;

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No noAtual, int valor) {
        if (noAtual == null) return new No(valor);

        if (valor < noAtual.getValor()) {
            noAtual.setFilhoEsquerdo(inserirRecursivo(noAtual.getFilhoEsquerdo(), valor));
        } else if (valor > noAtual.getValor()) {
            noAtual.setFilhoDireito(inserirRecursivo(noAtual.getFilhoDireito(), valor));
        } else {
            return noAtual; // valores duplicados não são inseridos
        }

        return balancear(noAtual);
    }

    public No buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private No buscarRecursivo(No noAtual, int valor) {
        if (noAtual == null) return null;
        if (valor == noAtual.getValor()) return noAtual;

        if (valor < noAtual.getValor()) {
            return buscarRecursivo(noAtual.getFilhoEsquerdo(), valor);
        } else {
            return buscarRecursivo(noAtual.getFilhoDireito(), valor);
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
            if (noAtual.getFilhoEsquerdo() == null) return noAtual.getFilhoDireito();
            if (noAtual.getFilhoDireito() == null) return noAtual.getFilhoEsquerdo();

            int menorValor = encontrarMenorValor(noAtual.getFilhoDireito());
            noAtual.setValor(menorValor);
            noAtual.setFilhoDireito(removerRecursivo(noAtual.getFilhoDireito(), menorValor));
        }

        return balancear(noAtual);
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

    private int fatorBalanceamento(No noAtual) {
        if (noAtual == null) return 0;
        return altura(noAtual.getFilhoEsquerdo()) - altura(noAtual.getFilhoDireito());
    }

    public No rotacaoDireita(No noAtual) {
        No apontadorEsquerdo = noAtual.getFilhoEsquerdo();
        No apontadorDireitoDoFilho = apontadorEsquerdo.getFilhoDireito();

        apontadorEsquerdo.setFilhoDireito(noAtual);
        noAtual.setFilhoEsquerdo(apontadorDireitoDoFilho);

        return apontadorEsquerdo;
    }

    public No rotacaoEsquerda(No noAtual) {
        No apontadorDireito = noAtual.getFilhoDireito();
        No apontadorEsquerdoDoFilho = apontadorDireito.getFilhoEsquerdo();

        apontadorDireito.setFilhoEsquerdo(noAtual);
        noAtual.setFilhoDireito(apontadorEsquerdoDoFilho);

        return apontadorDireito;
    }

    public No balancear(No noAtual) {
        int fb = fatorBalanceamento(noAtual);

        if (fb > 1) {
            if (fatorBalanceamento(noAtual.getFilhoEsquerdo()) < 0) {
                noAtual.setFilhoEsquerdo(rotacaoEsquerda(noAtual.getFilhoEsquerdo())); // Caso LR
            }
            return rotacaoDireita(noAtual); // Caso LL
        }

        if (fb < -1) {
            if (fatorBalanceamento(noAtual.getFilhoDireito()) > 0) {
                noAtual.setFilhoDireito(rotacaoDireita(noAtual.getFilhoDireito())); // Caso RL
            }
            return rotacaoEsquerda(noAtual); // Caso RR
        }

        return noAtual; // já está balanceado
    }
    public static void mostrarFator(ArvoreBinaria arvore, int valor) {
        No no = arvore.buscar(valor);
        if (no != null) {
            System.out.printf("FB de %d: %d\n", valor, arvore.fatorBalanceamento(no));
        } else {
            System.out.printf("Nó %d não encontrado.\n", valor);
        }
    }
}
