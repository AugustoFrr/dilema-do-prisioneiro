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



































    static int bubbleSort(int[] vetor) {
        int comparacoes = 0;
        for (int i = vetor.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    swap(vetor, j, j + 1);

                }
                comparacoes++;
            }
        }
        return comparacoes;
    }


    static int selectionSort(int v[]) {
        int comparacoes = 0;
        int menor;
        for (int i = 0; i < v.length - 1; i++) {
            menor = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[menor]) {
                    menor = j;
                }
                comparacoes++;
            }
            swap(v, i, menor);
        }
        return comparacoes;
    }


    static int insertionSort(int[] vetor) {
        int comparacoes = 0;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i; j > 0; j--) {
                if (vetor[j] < vetor[j - 1]) {
                    swap(vetor, j, j - 1);
                } else {
                    break;
                }
                comparacoes++;
            }
        }
        return comparacoes;
    }






















