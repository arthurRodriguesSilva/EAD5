abstract public class Lutador {
    String nome;
    int vida;
    int energia;
    int forca;
    int dano;

    public Lutador(String nome, int vida, int energia, int forca, int dano){
        this.nome = nome;
        this.vida = vida;
        this.energia = energia;
        this.forca = forca;
        this.dano =
    }

    public abstract void atacar(Lutador oponente);
    public abstract void especial(Lutador oponente);

    public void defender(Lutador oponente){
        this.energia -= oponente.forca * 0.6;
    }

    public void mostrarStatus(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Energia: " + this.energia);
    }

    public boolean estarVivo(){
        if (this.vida > 0){
            return true;
        }else{
            return false;
        }
    }
}
