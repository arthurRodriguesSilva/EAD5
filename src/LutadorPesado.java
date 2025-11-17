public class LutadorPesado extends Lutador{
    int especial;

    public LutadorPesado(String nome){
        super(nome, 150, 100, 20);
        this.especial = forca * 3;
    }

    @Override
    public void atacar(Lutador oponente){
        System.out.println("O ataque do lutador " + nome + " teve "+ forca + " de dano. ");
        energia -= 5;
        oponente.vida -= forca;
    }

    @Override
    public void especial(Lutador oponente){
        System.out.println("O ataque especial do lutador " + nome + " teve "+ especial + " de dano. ");
        int gasto = 20;
        energia -= gasto;
        System.out.println("Total de energia gasto: " + gasto);
        oponente.vida -= especial;
    }

}

