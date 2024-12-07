/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;
import inventario.Produto;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteProduto {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        //variaveis para defenir o produto
        int maxSize, escolha;
        
        maxSize= getNuProdutos(in);
        if(maxSize==0){
            Produto[] produtos = new Produto[maxSize];
                escolha = getMenuOpcao(in);
            executarMenuEscolha(escolha, produtos, in);
            }else{
                Produto[] produtos = new Produto[maxSize];
                adicionarParaOInventario(produtos,in);
        do{
            escolha = getMenuOpcao(in);
            executarMenuEscolha(escolha, produtos, in);
        }while(escolha!=0);        
        }
            }
    
    static void executarMenuEscolha(int escolha, Produto[] produtos, Scanner in){
        switch(escolha){
            case 1:
                System.out.println("Ver lista de produtos");
                mostraProdutos(produtos);
                break;
            case 2:
                System.out.println("Adcionar ao estoque");
                adicionaInventario(produtos, in);
                break;
            case 3:
                System.out.println("Reduzir estoque");
                reduzieEstoque(produtos, in);
                break;
            case 4:
                System.out.println("Descontinuar estoque");
                descontinuarInventario(produtos, in);
            case 5:
                System.out.println("Adcionar DVD(Selecione quantos deseja)");
                int quantia = in.nextInt();
                adicionarDVDParaOInventario(produtos, in,quantia);
                break;

            case 6:
                System.out.println("Adcionar CD(Selecione quantos deseja)");
                int quantia2 = in.nextInt();
                adicionarCDParaOInventario(produtos, in,quantia2);
                break;
        }
    }
    
    static void adicionarParaOInventario(Produto[] produtos, Scanner in){
        int tempCodigo;
        String tempNome;
        int tempQEstoque;
        double tempPreco;
        boolean tempEstado = true;
        
        
        
        for(int i = 0; i<produtos.length; i++){
                    in.nextLine();
                    //questionario
                    System.out.println("Nome do produto:");
                    tempNome = in.nextLine();
                    System.out.println("Quantia de estoque:");
                    tempQEstoque = in.nextInt();
                    System.out.println("Preço:");
                    tempPreco = in.nextDouble();
                    System.out.println("Código do produto:");
                    tempCodigo = in.nextInt();
                    System.out.println("Qual o estado do produto? true/false");
                    tempEstado = in.nextBoolean();
                    //criaçao do objeto
                    produtos[i] = new Produto (tempCodigo, tempNome, tempQEstoque, tempPreco);
    }
    }
    
        static int getNuProdutos(Scanner in){
        int maxSize = -1;
        
        do{
            try{
            System.out.println("Quantos itens deseja adcionar?\nCaso não deseje adcionar digite 0");
            maxSize = in.nextInt();
            if(maxSize<0)
                System.out.println("Valor incorreto");
            }catch(InputMismatchException e){
                System.out.println("Digite um número valido");
            }
            catch(Exception e){
                System.out.println("e");
                in.nextLine();
            }
            
            }while(maxSize<0);
        return maxSize;
        
}
    static void mostraProdutos(Produto[] produtos){
        for (Produto produto: produtos){
                System.out.println(produto);
            }
    }
    static int getMenuOpcao(Scanner in){
        int menuOpcao = -1;
    do{
        try{
    System.out.println("1.Ver inventário"
            + "\n2.Adcionar ao estoque."
            + "\n3.Reduzir do estoque."
            + "\n4.Descontinuar produto."
            + "\n5.Adicionar DVD"
            + "\n6.Adicionar CD"
            + "\n0.Sair.");
        menuOpcao = in.nextInt();
    }
    catch(Exception e){
            System.out.println("Escolha uma opção valida");
            in.nextLine();
            }
    }while(menuOpcao <0 || menuOpcao>7);
            
    return menuOpcao;
    }
    static int getProdutoCodigo(Produto[] produtos,Scanner in){
        int escolhaProduto =-1;
        
        for(int i= 0; i<produtos.length; i++)
            System.out.println(i + " : " + produtos[i].getNome());
    do{
        try{
            System.out.println("Coloque o número do item que deseja mudar:");
            escolhaProduto = in.nextInt();
            if (escolhaProduto<0 || escolhaProduto>produtos.length){
                System.out.println("Coloque uma opção válida");
            }
            }catch(InputMismatchException e){
                System.out.println("Digite um número valido");
            }
            catch(Exception e){
                System.out.println("e");
                in.nextLine();
            }
        }while(escolhaProduto<0 || escolhaProduto>produtos.length-1);
        return escolhaProduto;
    }
    static void adicionaInventario(Produto[] produtos,Scanner in){
        int escolhaProduto;
        int quantiaP = -1;
        escolhaProduto = getProdutoCodigo(produtos, in);
        
        do{
            try{
                System.out.println("Quantos produtos quer adicionar?");
                quantiaP = in.nextInt();
                if(quantiaP<0)
                    System.out.println("Digite quantos produtos deseja adcionar");
                }catch(InputMismatchException e){
                System.out.println("Digite um número valido");
            }
            catch(Exception e){
                System.out.println("e");
                in.nextLine();
            }
        }while(quantiaP<0);
        
        produtos[escolhaProduto].adicionaAoInventario(quantiaP);
    }
    static void descontinuarInventario(Produto[] produtos, Scanner in){
        int escolhaProduto;
        
        escolhaProduto=getProdutoCodigo(produtos, in);
        produtos[escolhaProduto].setEstado(false);
    }
    static void reduzieEstoque(Produto[] produtos, Scanner in){
    int escolhaProduto;
    int quantiaP = -1;
    escolhaProduto = getProdutoCodigo(produtos, in);
    
    do{
        try{
            System.out.println("Quantos produtos deseja reduzir?");
            quantiaP = in.nextInt();
            if(quantiaP<0)
                System.out.println("Insira um valor valido");
            if(quantiaP>produtos[escolhaProduto].getqEstoque())
                System.out.println("Não tem em estoque");
        }catch(InputMismatchException e) {
System.out.println("Tipo incorreto de dados inserido!");
in.nextLine();
}catch(Exception e) {
System.out.println(e);
in.nextLine();
}
}while(quantiaP<0||quantiaP>produtos[quantiaP].getqEstoque());
produtos[escolhaProduto].deductDoInventario(quantiaP);
        }
    static void adicionarCDParaOInventario(Produto[] produtos, Scanner in, int quantia) {
    int tempCodigo;
    String tempNome;
    int tempQEstoque;
    double tempPreco;
    boolean tempEstado = true;
    String tempArtista;
    String tempSelo;
    int tempNumMusicas;

    for (int i = 0; i < quantia; i++) { // Itera pelo número de CDs a serem adicionados
        in.nextLine(); // Limpar o buffer
        // Questionário
        System.out.println("Nome do CD:");
        tempNome = in.nextLine();
        System.out.println("Nome do artista:");
        tempArtista = in.nextLine();
        System.out.println("Nome do selo de gravação:");
        tempSelo = in.nextLine();
        System.out.println("Quantia de músicas:");
        tempNumMusicas = in.nextInt();
        System.out.println("Quantia de estoque:");
        tempQEstoque = in.nextInt();
        System.out.println("Preço:");
        tempPreco = in.nextDouble();
        System.out.println("Código do produto:");
        tempCodigo = in.nextInt();
        System.out.println("Qual o estado do produto? true/false");
        tempEstado = in.nextBoolean();

        // Criação do objeto CD
        for (int j = 0; j < produtos.length; j++) {
            if (produtos[j] == null) { // Encontra o primeiro espaço vazio
                produtos[j] = new CD(tempCodigo, tempNome, tempQEstoque, tempPreco, tempArtista, tempNumMusicas, tempSelo);
                break;
            }
        }
    }
}

    static void adicionarDVDParaOInventario(Produto[] produtos, Scanner in, int quantia) {
    int tempCodigo;
    String tempNome;
    int tempQEstoque;
    double tempPreco;
    boolean tempEstado = true;
    String tempEstudio;
    int tempClassificacao;
    int tempDuracao;

    for (int i = 0; i < quantia; i++) { // Itera pelo número de DVDs a serem adicionados
        in.nextLine(); // Limpar o buffer
        // Questionário
        System.out.println("Nome do DVD:");
        tempNome = in.nextLine();
        System.out.println("Nome do estúdio:");
        tempEstudio = in.nextLine();
        System.out.println("Classificação de idade:");
        tempClassificacao = in.nextInt();
        System.out.println("Duração do filme");
        tempDuracao = in.nextInt();
        System.out.println("Quantia de estoque:");
        tempQEstoque = in.nextInt();
        System.out.println("Preço:");
        tempPreco = in.nextDouble();
        System.out.println("Código do produto:");
        tempCodigo = in.nextInt();
        System.out.println("Qual o estado do produto? true/false");
        tempEstado = in.nextBoolean();

        // Criação do objeto DVD
        for (int j = 0; j < produtos.length; j++) {
            if (produtos[j] == null) { // Encontra o primeiro espaço vazio
                produtos[j] = new DVD(tempCodigo, tempNome, tempQEstoque, tempPreco, tempDuracao, tempClassificacao, tempEstudio);
                break;
            }
        }
    }
}
}
    
