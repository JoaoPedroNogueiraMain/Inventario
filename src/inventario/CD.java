/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author Pichau
 */
public class CD extends Produto{
     public String artista;
     public int numMusicas;
     public String selo;
     
     public CD(int codigo, String nome, int qEstoque, double preco, String art, int numMusicas, String selo){
        super(codigo,nome,qEstoque,preco);
        this.artista = art;
        this.numMusicas = numMusicas;
        this.selo = selo;
}
     
     public String toString()
    {
    return "\n\nCódigo : " + this.codigo
    + "\nNome : " + this.nome
    + "\nQuantia em estoque: " + this.qEstoque
    + "\nPreço : " + this.preco
    + "\nEstado: " + this.estado
    + "\nValor de Estoque : " + getValorEstoque()
    + "\nArtista : " + this.artista
    +"\nNúmero de músicas : " + this.numMusicas
    +"\nEstudio de gravação : " + this.selo;
    }

    /**
     * @return the artista
     */
    public String getArtista() {
        return artista;
    }

    /**
     * @param artista the artista to set
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
     * @return the numMusicas
     */
    public int getNumMusicas() {
        return numMusicas;
    }

    /**
     * @param numMusicas the numMusicas to set
     */
    public void setNumMusicas(int numMusicas) {
        this.numMusicas = numMusicas;
    }

    /**
     * @return the selo
     */
    public String getSelo() {
        return selo;
    }

    /**
     * @param selo the selo to set
     */
    public void setSelo(String selo) {
        this.selo = selo;
    }
     
}

