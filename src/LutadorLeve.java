public class LutadorLeve extends Lutador{
    int especial;

    public LutadorLeve(String nome){
        super(nome, 100, 100, 10);
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
        int gasto = 10;
        energia -= gasto;
        System.out.println("Total de energia gasto: " + gasto);
        oponente.vida -= especial;
    }
}
