package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import modelo.Produto;
import repository.ProdutoDAO;

@ViewScoped
@Named
public class ProdutoController implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 9106205546583113700L;
	
	private Produto produtoForm;
	
    private List<Produto> listaDeProduto; // = new ArrayList<>();
    
    private Produto produtoSelecionado;

    @Inject
    private ProdutoDAO produtoDAO;

    @PostConstruct
    private void innit (){
    	
        produtoForm = new Produto();
        
        //listaDeProduto = produtoDAO.consultar();
        
    }

    public void cadastrar(){
    	
       // if (!listaDeProduto.contains(produtoForm)) {
        	
            produtoDAO.salvar(produtoForm);
            
       // }else{
        	
         //   produtoDAO.editar(produtoForm);
            
        //}
        
        limpar();
        
    }

    public void excluir(){
    	
        produtoDAO.remover(produtoForm);
        
        limpar();
        
    }
    
    public void limpar(){
    	
        this.produtoForm = new Produto();
        
        this.listaDeProduto = produtoDAO.consultar();
        
    }

    public void aoSelecionar(){
    	
        this.produtoForm = produtoSelecionado;
        
    }

    public void aoDesselecionar(){
    	
        limpar();
        
    }

    public List<Produto> getProdutos() {
    	
        return listaDeProduto;
        
    }
    
    public void setProdutos(List<Produto> produtos) {
    	
        this.listaDeProduto = produtos;
        
    }

    public Produto getProdutoSelecionado() {
    	
        return produtoSelecionado;
        
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
    	
        this.produtoSelecionado = produtoSelecionado;
        
    }

    public Produto getProdutoForm() {
    	
        return produtoForm;
        
    }

    public void setProdutoForm(Produto produtoForm) {
    	
        this.produtoForm = produtoForm;
        
    }
}
