package GoBots.FaleConosco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Mensagem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Integer id;
    private String nome;
    private String mensagemEnviada;
    
    /**
     * Criação de Getters e Setters
     */

    /*ID*/
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    
    /*NOME*/
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    /*Mensagem*/
    public void setMensagemEnviada(String mensagemEnviada){
        this.mensagemEnviada = mensagemEnviada;
    }
    public String getMensagemEnviada(){
        return this.mensagemEnviada;
    }
}
