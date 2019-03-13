package controller;


import cdi.RequestBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class TesteController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6153551863879307852L;

	@Inject
    private RequestBean reqBean;

    private String mensagemBoasVindas = "Hello, word...Fabrício!";
    private String nome;

    @PostConstruct
    private void innit (){
        this.setMensagemBoasVindas("Inicializando Mensagem PostConstruct");
    }

    public void alteraMensagem(){
        this.setMensagemBoasVindas("Contador de Cliques: " + reqBean.imprimeContador());
    }

    public String getMensagemBoasVindas() {
        return mensagemBoasVindas;
    }

    public void setMensagemBoasVindas(String mensagemBoasVindas) {
        this.mensagemBoasVindas = mensagemBoasVindas;
    }

    public void enviar(){
        System.out.println(this.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
