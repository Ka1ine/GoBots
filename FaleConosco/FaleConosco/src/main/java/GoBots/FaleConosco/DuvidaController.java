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
@RequestMapping("/duvida")
public class DuvidaController {

    @Autowired
    private DuvidaRepository duvidaRepository;
    private DuvidaLista duvidalista = new DuvidaLista();

    @GetMapping("/")
    public String duvidaForm() {
        return "index";
    }

    //Inserir
    @PostMapping(path="/insere") 
    public @ResponseBody String addNewDuvida(@RequestParam String nome, @RequestParam Integer telefone, @RequestParam String email, @RequestParam String mensagem) {
        Duvida duvida = new Duvida();
        duvida.setNome(nome);
        duvida.setTelefone(telefone);
        duvida.setEmail(email);
        duvida.setMensagem(mensagem);
        duvidaRepository.save(duvida);
        return nome + " " + telefone + " "+ email + " " + mensagem;
    } 

    @GetMapping(path="/duvidaLista")
    public @ResponseBody String getAllDuvida() {
        Iterable<Duvida>resultado = duvidaRepository.findAll();
        return duvidalista.listaDuvida(resultado);
    }
    
    //FILTRAR
    @GetMapping(path="/filtro")
    public @ResponseBody String getDuvida(@RequestParam Integer telefone) {
        Iterable<Duvida> resultado = duvidaRepository.findDuvida(telefone);
        return duvidalista.listaDuvida(resultado);
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
    public @ResponseBody String updateDuvida(@RequestParam Integer telefone, @RequestParam Integer id) {
        duvidaRepository.findById(id);
        Optional<Duvida> o = duvidaRepository.findById(id);
        if(o.isPresent()){
            Duvida duvida = o.get();
            duvida.setTelefone(telefone);
            duvidaRepository.save(duvida);
        }
        return "updateResposta";
    } 
    
    //DELETAR
    @GetMapping(path="/deleteForm")
    public String deleteForm() {
        return "delete";
    } 

    @PostMapping(path="/delete")
    public @ResponseBody String deleteDuvida(@RequestParam Integer id) {
        duvidaRepository.deleteById(id);
        return "updateResposta";
    } 
}
