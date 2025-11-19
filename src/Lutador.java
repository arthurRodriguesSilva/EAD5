abstract public class Lutador {
    String nome;
    int vida;
    int energia;
    int forca;

    public Lutador(String nome, int vida, int energia, int forca){
        this.nome = nome;
        this.vida = vida;
        this.energia = energia;
        this.forca = forca;
    }

    public abstract void atacar(Lutador oponente);
    public abstract void especial(Lutador oponente);

    public void defender(Lutador oponente){
        int perda = (int) (oponente.forca * 0.6);
        this.energia -= perda;

        if(this.energia < 0) this.energia = 0;
    }

    public void mostrarStatus(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Energia: " + this.energia);
        System.out.println("===========================");
    }

    public boolean estarVivo(){
        return this.vida > 0;
    }

    public void receberDano(int dano){
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
        System.out.println(this.nome + " recebeu " + dano + " de dano!");
    }
}
