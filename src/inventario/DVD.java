/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author Pichau
 */
public class DVD extends Produto{
    private int duracao;
    private int classificacao;
    private String estudio;
    
    public DVD(int codigo, String nome, int qEstoque, double preco, int duracao, int classificacao, String estudio){
        super(codigo,nome,qEstoque,preco);
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.estudio = estudio;
}
    public String toString()
    {
    return "\n\nCódigo : " + this.codigo
    + "\nNome : " + this.nome
    + "\nQuantia em estoque: " + this.qEstoque
    + "\nPreço : " + this.preco
    + "\nEstado: " + this.estado
    + "\nValor de Estoque : " + getValorEstoque()
    + "\nArtista : " + this.duracao
    +"\nNúmero de músicas : " + this.classificacao
    +"\nEstudio de gravação : " + this.estudio;
    }
    
    public double getValorEstoque(){
        return (1.05*(super.getPreco()*super.getqEstoque()));
    }
    /**
     * @return the duracao
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the classificacao
     */
    public int getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * @return the estudio
     */
    public String getEstudio() {
        return estudio;
    }

    /**
     * @param estudio the estudio to set
     */
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
}