import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos lutadores deseja adicionar?");
        int quantidade = sc.nextInt();

        Lutador [] lutadores = new Lutador[quantidade];

        sc.nextLine();
        for(int i = 0; i < lutadores.length; i++){
            System.out.println("Qual o nome do " + (i + 1) + "º lutador?");
            String nome = sc.nextLine();

            boolean validade = false;
            while(!validade) {
                System.out.println("===== TIPOS DE LUTADORES =====");
                System.out.println(" 1 - Lutador Leve");
                System.out.println(" 2 - Lutador Médio");
                System.out.println(" 3 - Lutador Pesado");
                int opcao = sc.nextInt();

                if (opcao == 1){
                    lutadores[i] = new LutadorLeve(nome);
                    validade = true;
                } else if (opcao == 2){
                    lutadores[i] = new LutadorMedio(nome);
                    validade = true;
                } else if (opcao == 3){
                    lutadores[i] = new LutadorPesado(nome);
                    validade = true;
                } else {
                    System.out.println("Lutador inválido, tente novamente.");
                }
                sc.nextLine();
            }
        }
        for(int i = 0; i < lutadores.length; i++){
            System.out.println("===== LUTADOR " + lutadores[i].nome + " =====");
            lutadores[i].mostrarStatus();
        }
        while(lutadores[0].vida > 0){

        }
        int turno = 0;
        do{
            System.out.println("TURNO " + turno);
            for (int i=0; i < lutadores.length; i++){
                Lutador atacante = lutadores[i];
            }

        }while(true);
    }
}