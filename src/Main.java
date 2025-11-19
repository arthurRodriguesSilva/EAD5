import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int quantidade = 0;
            boolean quantidadeValida = false;
            while (!quantidadeValida) {
                System.out.println("Quantos lutadores deseja adicionar?");
                try {
                    quantidade = sc.nextInt();
                    if (quantidade > 0) {
                        quantidadeValida = true;
                    } else {
                        System.out.println("Digite um número maior que zero.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("São válidos apenas números. Tente novamente.");
                    sc.nextLine();
                }
            }

            Lutador[] lutadores = new Lutador[quantidade];
            sc.nextLine();

            for (int i = 0; i < lutadores.length; i++) {
                System.out.println("Qual o nome do " + (i + 1) + "º lutador?");
                String nome = sc.nextLine();

                boolean validade = false;
                while (!validade) {
                    System.out.println("===== TIPOS DE LUTADORES =====");
                    System.out.println(" 1 - Lutador Leve");
                    System.out.println(" 2 - Lutador Médio");
                    System.out.println(" 3 - Lutador Pesado");

                    int opcao = 0;
                    boolean opcaoValida = false;
                    while (!opcaoValida) {
                        try {
                            opcao = sc.nextInt();
                            if (opcao >= 1 && opcao <= 3) {
                                opcaoValida = true;
                            } else {
                                System.out.println("Opção inválida. Digite 1, 2 ou 3.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas números!");
                            sc.nextLine();
                        }
                    }

                    switch (opcao) {
                        case 1 -> lutadores[i] = new LutadorLeve(nome);
                        case 2 -> lutadores[i] = new LutadorMedio(nome);
                        case 3 -> lutadores[i] = new LutadorPesado(nome);
                    }
                    validade = true;
                    sc.nextLine();
                }
            }

            for (int i = 0; i < lutadores.length; i++) {
                System.out.println("===== LUTADOR " + lutadores[i].nome + " =====");
                lutadores[i].mostrarStatus();
            }

            int i1 = -1, i2 = -1;

            while (i1 < 0 || i1 >= quantidade) {
                System.out.println("Escolha o número do primeiro lutador (1 a " + quantidade + "):");
                try {
                    i1 = sc.nextInt() - 1;
                    if (i1 < 0 || i1 >= quantidade) {
                        System.out.println("Número fora do intervalo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Digite apenas números!");
                    sc.nextLine();
                }
            }

            while (i2 < 0 || i2 >= quantidade) {
                System.out.println("Escolha o número do segundo lutador (1 a " + quantidade + "):");
                try {
                    i2 = sc.nextInt() - 1;
                    if (i2 < 0 || i2 >= quantidade) {
                        System.out.println("Número fora do intervalo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Digite apenas números!");
                    sc.nextLine();
                }
            }

            Lutador l1 = lutadores[i1];
            Lutador l2 = lutadores[i2];

            System.out.println("=====INÍCIO DA BATALHA=====");
            System.out.println(l1.nome + " VS " + l2.nome);

            int turno = 1;

            while (l1.estarVivo() && l2.estarVivo()) {
                System.out.println("\n===== TURNO " + turno + " =====");

                int acao = 0;
                boolean acaoValida = false;
                while (!acaoValida) {
                    System.out.println("\n===== Vez de " + l1.nome + " =====");
                    System.out.println("1 - Atacar");
                    System.out.println("2 - Especial");
                    System.out.println("3 - Defender");

                    try {
                        acao = sc.nextInt();
                        if (acao >= 1 && acao <= 3) {
                            acaoValida = true;
                        } else {
                            System.out.println("Escolha inválida. Digite 1, 2 ou 3.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Digite apenas números!");
                        sc.nextLine();
                    }
                }

                switch (acao) {
                    case 1 -> l1.atacar(l2);
                    case 2 -> l1.especial(l2);
                    case 3 -> l1.defender(l2);
                }

                if (!l2.estarVivo()) break;

                System.out.println("\n===== Vez de " + l2.nome + " =====");
                int acaoIA = (int) (Math.random() * 3) + 1;

                switch (acaoIA) {
                    case 1 -> {
                        System.out.println(l2.nome + " escolheu ATACAR!");
                        l2.atacar(l1);
                    }
                    case 2 -> {
                        System.out.println(l2.nome + " tentou usar ESPECIAL!");
                        l2.especial(l1);
                    }
                    case 3 -> {
                        System.out.println(l2.nome + " escolheu DEFENDER!");
                        l2.defender(l1);
                    }
                }

                System.out.println("===== STATUS ATUAL =====");
                l1.mostrarStatus();
                l2.mostrarStatus();

                turno++;
            }

            System.out.println("\n===== FIM DA BATALHA =====");

            if (l1.estarVivo())
                System.out.println(l1.nome + " VENCEU!");
            else
                System.out.println(l2.nome + " VENCEU!");

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}

