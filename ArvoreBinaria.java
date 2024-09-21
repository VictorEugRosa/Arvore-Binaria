// Classe que representa um nó da árvore binária
class No {
    int valor;
    No esquerda;
    No direita;

    public No(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

// Classe que representa a árvore binária
public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Método para adicionar um novo nó à árvore
    public void adicionar(int valor) {
        raiz = adicionarRecursivo(raiz, valor);
    }

    private No adicionarRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = adicionarRecursivo(atual.direita, valor);
        }

        return atual;
    }

    // Método para verificar se um valor existe na árvore
    public boolean contemNo(int valor) {
        return contemNoRecursivo(raiz, valor);
    }

    private boolean contemNoRecursivo(No atual, int valor) {
        if (atual == null) {
            return false;
        }
        if (valor == atual.valor) {
            return true;
        }
        return valor < atual.valor
                ? contemNoRecursivo(atual.esquerda, valor)
                : contemNoRecursivo(atual.direita, valor);
    }

    // Método para imprimir a árvore em ordem
    public void percorrerEmOrdem(No no) {
        if (no != null) {
            percorrerEmOrdem(no.esquerda);
            System.out.print(" " + no.valor);
            percorrerEmOrdem(no.direita);
        }
    }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.adicionar(6);
        arvore.adicionar(4);
        arvore.adicionar(8);
        arvore.adicionar(3);
        arvore.adicionar(5);
        arvore.adicionar(7);
        arvore.adicionar(9);

        System.out.println("Árvore em ordem:");
        arvore.percorrerEmOrdem(arvore.raiz);

        System.out.println("\nContém o valor 5? " + arvore.contemNo(5));
        System.out.println("Contém o valor 10? " + arvore.contemNo(10));
    }
}
