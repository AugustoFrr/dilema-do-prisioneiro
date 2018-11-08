package dilemaDoPrisioneiro;

import java.util.Scanner;
//Augusto Barbosa Ferreira

public class dilemaMain {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int estrategia, acao, partidas = 0;
        int acaoDois, aux = 0;
        boolean retaliate = false;

        int tt = 0, cc = 0, ct = 0; //Trair-Trair, Cooperar-Cooperar, Cooperar-Trair

        System.out.println("Bem-vindo ao dilema do prisioneiro!");

        do {
            System.out.println("\nEscolha a estrategia a ser utilizada:");
            System.out.println("<1> Não Iterado");
            System.out.println("<2> Olho por olho");
            System.out.println("<3> Olho por dois olhos");
            System.out.println("<4> Provador Ingênuo");
            System.out.println("<5> Retaliador Permanente");
            System.out.println("<6> Sair");

            estrategia = scan.nextInt();

            if (estrategia == 6) {

                System.out.println("\nFim de jogo!");
                System.out.println("Partidas jogadas: " + partidas);
                try {
                    System.out.println("Relatório de jogadas: \ntrair X trair: " + ((tt * 100) / (tt + ct + cc) + "%")
                            + "\ncooperar X trair: " + ((ct * 100) / (tt + ct + cc) + "%")
                            + "\ncooperar X cooperar: " + ((cc * 100) / (tt + ct + cc) + "%"));
                } catch (ArithmeticException e) {
                    System.out.println("Relatório indisponível.");
                }
                break;

            } else if (estrategia >= 1 && estrategia <= 5) {

                partidas++;
                System.out.println("O que você vai fazer?");
                System.out.println("<1> Trair");
                System.out.println("<2> Cooperar");
                acao = scan.nextInt();

                acaoDois = aux;
                aux = acao;

                int comparsa = 0;

                switch (estrategia) {
                    case 1:
                        comparsa = (int) (1 + Math.random() * 2);
                        break;

                    case 2:
                        if (partidas == 0) {
                            comparsa = (int) (1 + Math.random() * 2);
                        } else {
                            if (aux == 1) {
                                comparsa = 1;
                            } else if (aux == 2) {
                                comparsa = 2;
                            }
                        }
                        break;

                    case 3:

                        if (acaoDois == 1 && aux == 1) {
                            comparsa = 1;
                        } else {
                            comparsa = 2;
                        }
                        break;

                    case 4:
                        if (5 != (1 + Math.random() * 5)) {
                            comparsa = (int) (1 + Math.random() * 2);
                        } else {
                            if (acaoDois == 1) {
                                comparsa = 1;
                            } else {
                                comparsa = 2;
                            }
                        }
                        break;

                    case 5:

                        if (retaliate == false) {
                            comparsa = 2;
                        } else {
                            comparsa = 1;
                        }
                        if (acao == 1) {
                            retaliate = true;
                        }
                        break;

                }
                if (acao == 1 && comparsa == 1) {
                    tt++;
                    System.out.println("Você traiu seu comparsa e ele também te traiu.");
                    System.out.println("Os dois foram punidos com 5 anos de prisão.");
                } else if (acao == 1 && comparsa == 2) {
                    ct++;
                    System.out.println("Você traiu seu comparsa e ele ficou calado.");
                    System.out.println("Você está livre.");
                    System.out.println("Seu comparsa foi penalizado com 10 anos de prisão.");
                } else if (acao == 2 && comparsa == 1) {
                    ct++;
                    System.out.println("Você cooperou com seu comparsa e ele te traiu.");
                    System.out.println("Você foi penalizado com 10 anos de prisão.");
                    System.out.println("Seu comparsa está livre.");
                } else {
                    cc++;
                    System.out.println("Você e seu comparsa decidiram ficar em silêncio.");
                    System.out.println("Os dois foram penalizados com 2 anos de prisão.");
                }
            } else {
                System.out.println("Valor inválido");
            }

        } while (estrategia != 6);

    }

}


































    static int mergeSortIterativo(int[] vetor) {
        int somaComparacoes = 0;
        int p, r;
        int b = 1;
        while (b < vetor.length) {
            p = 0;
            while (p + b < vetor.length) {
                r = p + 2 * b;
                if (r > vetor.length) {
                    r = vetor.length;
                }
                somaComparacoes += merge(vetor, p, p + b - 1, r - 1);
                p = p + 2 * b;
            }
            b = b * 2;
        }
        return somaComparacoes;
    }

    static int merge(int[] vetor, int p, int q, int r) {
        int comparacoes = 0;
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] aux1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            aux1[i] = vetor[i + p];
        }
        int[] aux2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            aux2[i] = vetor[i + q + 1];
        }
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (i == n1) {
                vetor[k] = aux2[j++];
            } else if (j == n2) {
                vetor[k] = aux1[i++];
            } else if (aux1[i] < aux2[j]) {
                vetor[k] = aux1[i++];
            } else {
                vetor[k] = aux2[j++];
            }
            comparacoes++;
        }
        return comparacoes;
    }





















