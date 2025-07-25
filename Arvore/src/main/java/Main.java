public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);
        arvore.imprimirPreOrdem();
        System.out.println("A Altura do Nó " + arvore.capturarNo(50).valor + " é "+arvore.altura(arvore.capturarNo(50)));
        arvore.imprimirEmOrdem();
        arvore.imprimirPosOrdem();
    }
}

