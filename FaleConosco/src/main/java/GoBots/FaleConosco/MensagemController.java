package GoBots.FaleConosco;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    private MensagemRepository mensagemRepository;
    private MensagemLista mensagemlista = new MensagemLista();

    @GetMapping("/")
    public String mensagemForm() {
        return "insere";
    }

    /**
     * Recebe o nome e a mensagem enviada
     * Trata essa mensagem no banco de dados e devolve a mensagem tratada
     */
    @PostMapping(path="/insere") 
    public @ResponseBody String addNewMensagem(@RequestParam String nome, @RequestParam String mensagemEnviada) {
        Mensagem mensagem = new Mensagem();
        mensagem.setNome(nome);
        mensagem.setMensagemEnviada(mensagemEnviada);
        mensagemRepository.save(mensagem);
        return "<div style=\"font-size:25px; display: inline-block; padding-left: 450px; color: #4054B2; padding-top: 200px;\"><p><b>Nome: </b>" + nome + "</p>"+
        "<b>Sua mensagem</b>" + getMensagemTratada(mensagemEnviada) + "</div>";
    } 
    /**
     * Busca a mensagem eviada no banco de dados 
     */
    public String getMensagemTratada(String mensagemEnviada){
        Iterable<String> mensagem = mensagemRepository.findTraducao(mensagemEnviada);
        String traduzida = mensagem.toString();
        /**
         * Retira os "[]" da mensagem
         * Retorna a mensagem tratada caso tenha no banco de dados
         */
        traduzida = traduzida.substring(1, traduzida.length()-1);
        if(traduzida.isEmpty()) {
            return "<b>: </b>" + mensagemEnviada;
        }   
        else {
            return " <b>tratada: </b>" + traduzida;
        }
    }

    /**
     * Pega todos as mensagem enviadas no banco de dados
     * OBS: essas mensagens são exibidas na tela sem serem tratadas
     */
    @GetMapping(path="/mensagemLista")
    public @ResponseBody String getAllMensagem() {
        Iterable<Mensagem>resultado = mensagemRepository.findAll();
        return mensagemlista.listaMensagem(resultado);
    }
    
    /**
     * Filtra todas as mensagens pelo nome 
     */
    @GetMapping(path="/filtro")
    public @ResponseBody String getMensagem(@RequestParam String nome) {
        Iterable<Mensagem> resultado = mensagemRepository.findMensagem(nome);
        return mensagemlista.listaMensagem(resultado);
    } 

    @GetMapping(path="/filtroForm")
    public String filtroForm() {
        return "filtro";
    } 

    /**
     * Update das mensagens pelo ID 
     */
    @PostMapping(path="/update")
    public @ResponseBody String updateMensagem(@RequestParam String mensagemEnviada, @RequestParam Integer id) {
        mensagemRepository.findById(id);
        Optional<Mensagem> o = mensagemRepository.findById(id);
        if(o.isPresent()){
            Mensagem mensagem = o.get();
            mensagem.setMensagemEnviada(mensagemEnviada);
            mensagemRepository.save(mensagem);
        }
        return "<div style=\"font-size:40px; display: inline-block; padding-left: 390px; padding-top: 200px; font-family: 'Poppins', sans-serif; color: #4054B2;\"> Sua mensagem foi atualizada :) </div>";
    } 

    @GetMapping(path="/updateForm")
    public String updateForm() {
        return "update";
    }

    /**
     * Deleta as mensagens pelo ID
     */
    @PostMapping(path="/delete")
    public @ResponseBody String deleteMensagem(@RequestParam Integer id) {
        mensagemRepository.deleteById(id);
        return "<div style=\"font-size:40px; display: inline-block; padding-left: 420px; padding-top: 200px; font-family: 'Poppins', sans-serif; color: #4054B2;\"> Sua mensagem foi deletada :) </div>" ;
    } 

    @GetMapping(path="/deleteForm")
    public String deleteForm() {
        return "delete";
    }
}