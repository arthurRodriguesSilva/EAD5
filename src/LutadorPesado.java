public class LutadorPesado extends Lutador{
    int especial;

    public LutadorPesado(String nome){
        super(nome, 100, 100, 10);
    }

    @Override
    public void atacar(Lutador oponente){
        if (energia < 5) {
            System.out.println(nome + "tentou atacar, porém está sem energia.");
            return;
        }

        energia -= 5;
        System.out.println("O ataque do lutador " + nome + " teve " + forca + " de dano. (-5 energia)");
        oponente.receberDano(forca);
    }

    @Override
    public void especial(Lutador oponente){
        int gasto = 20;
        if (energia < gasto){
            System.out.println(nome + "tentou usar ESPECIAL, porém não tem energia");
            return;
        }
        int danoEspecial = forca * 3;
        energia -= gasto;
        System.out.println("O ataque especial do lutador " + nome + " teve " + danoEspecial + " de dano!");
        System.out.println("Total de energia gasto: " + gasto);
        oponente.receberDano(danoEspecial);
    }
}
