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
    private String mensagemTratada;

    //GETS E SETS
    //ID
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    
    //Nome
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    //Mensagem
    public void setMensagemEnviada(String mensagemEnviada){
        this.mensagemEnviada = mensagemEnviada;
    }
    public String getMensagemEnviada(){
        return this.mensagemEnviada;
    }

    //MensagemTratada
    public void setMensagemTratada(String mensagemTratada){
        this.mensagemTratada = mensagemTratada;
    }
    public String getMensagemTratada(){
        return this.mensagemTratada;
    }
}
