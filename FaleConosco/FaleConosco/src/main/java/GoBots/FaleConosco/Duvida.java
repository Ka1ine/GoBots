package GoBots.FaleConosco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Duvida {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Integer id;
    String nome;
    Integer telefone;
    String email;
    String mensagem;

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

    //Telefone
    public void setTelefone(Integer telefone){
        this.telefone = telefone;
    }
    public Integer getTelefone(){
        return this.telefone;
    }

    //Email
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    
    //Mensagem
    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }
    public String getMensagem(){
        return this.mensagem;
    }
}
