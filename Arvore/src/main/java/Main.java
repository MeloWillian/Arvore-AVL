public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        System.out.println("=== Teste de Balanceamento AVL ===\n");

        int[] valores = {50, 40, 60, 30, 45, 35, 25, 20}; // Provoca rotações automáticas
        for (int v : valores) {
            System.out.println("Inserindo: " + v);
            arvore.inserir(v);
        }

        System.out.println("\nAltura da árvore após inserções: " + arvore.altura(arvore.raiz));

        System.out.println("\nFator de balanceamento dos principais nós:");
        ArvoreBinaria.mostrarFator(arvore, 50);
        ArvoreBinaria.mostrarFator(arvore, 40);
        ArvoreBinaria.mostrarFator(arvore, 30);
        ArvoreBinaria.mostrarFator(arvore, 25);

        System.out.println("\nPré-ordem final para verificar estrutura balanceada:");
        arvore.imprimirPreOrdem();

        System.out.println("\nRemovendo 30 (nó com dois filhos, causa rebalanceamento):");
        arvore.remover(30);
        arvore.imprimirPreOrdem();

        System.out.println("\nAltura final: " + arvore.altura(arvore.raiz));
    }}

