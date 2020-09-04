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

    //INSERIR
    @PostMapping(path="/insere") 
    public @ResponseBody String addNewMensagem(@RequestParam String nome, @RequestParam String mensagemEnviada) {
        Mensagem mensagem = new Mensagem();
        mensagem.setNome(nome);
        mensagem.setMensagemEnviada(mensagemEnviada);
        /*mensagem.setMensagemTratada(getMensagemTratada(mensagemEnviada));*/
        mensagemRepository.save(mensagem);
        return nome + "<br> " + getMensagemTratada(mensagemEnviada);
    } 

    public String getMensagemTratada(String mensagemEnviada){
        Iterable<String> mensagem = mensagemRepository.findTraducao(mensagemEnviada);
        String traduzida = mensagem.toString();
        traduzida = traduzida.substring(1, traduzida.length()-1);

        if(traduzida.isEmpty()){
            return mensagemEnviada;
        }   
        else {
            return traduzida;
        }
    }

    //Lista Completa das mensagem tratadas
    @GetMapping(path="/mensagemLista")
    public @ResponseBody String getAllMensagem() {
        Iterable<Mensagem>resultado = mensagemRepository.findAll();
        return mensagemlista.listaMensagem(resultado);
    }
    
    //FILTRAR
    @GetMapping(path="/filtro")
    public @ResponseBody String getMensagem(@RequestParam String nome) {
        Iterable<Mensagem> resultado = mensagemRepository.findMensagem(nome);
        return mensagemlista.listaMensagem(resultado);
    } 

    @GetMapping(path="/filtroForm")
    public String filtroForm() {
        return "filtro";
    } 

    //FAZER UPDATE
    @GetMapping(path="/updateForm")
    public String updateForm() {
        return "update";
    } 

    @PostMapping(path="/update")
    public @ResponseBody String updateMensagem(@RequestParam String mensagemEnviada, @RequestParam Integer id) {
        mensagemRepository.findById(id);
        Optional<Mensagem> o = mensagemRepository.findById(id);
        if(o.isPresent()){
            Mensagem mensagem = o.get();
            mensagem.setMensagemEnviada(mensagemEnviada);
            mensagemRepository.save(mensagem);
        }
        return "updateResposta";
    } 
    
    //DELETAR
    @GetMapping(path="/deleteForm")
    public String deleteForm() {
        return "delete";
    } 

    @PostMapping(path="/delete")
    public @ResponseBody String deleteMensagem(@RequestParam Integer id) {
        mensagemRepository.deleteById(id);
        return "updateResposta";
    } 
}