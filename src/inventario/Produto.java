package inventario;
/**
 *
 * @author Joao
 */
public class Produto {
    public int codigo;
    public String nome;
    public int qEstoque;
    public double preco;
    public boolean estado;
    
    
public Produto(){

}

public Produto(int id, String nome, int qet, double preco){
    this.codigo = id;
    this.nome = nome;
    this.qEstoque = qet;
    this.preco = preco;
}
public void adicionaAoInventario(int estoque){
    this.qEstoque += estoque;
}

public void deductDoInventario(int estoque){
    this.qEstoque -= estoque;
}
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the qEstoque
     */
    public int getqEstoque() {
        return qEstoque;
    }

    /**
     * @param qEstoque the qEstoque to set
     */
    public void setqEstoque(int qEstoque) {
        this.qEstoque = qEstoque;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public boolean setEstato(){
        return estado;
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    public double getValorEstoque(){
        return preco*qEstoque;
    }
    public String toString()
    {
    return "\n\nCódigo : " + this.codigo
    + "\nNome : " + this.nome
    + "\nQuantia em estoque: " + this.qEstoque
    + "\nPreço : " + this.preco
    + "\nEstado: " + this.estado
    + "\nValor de Estoque : " + getValorEstoque();
    }
}
