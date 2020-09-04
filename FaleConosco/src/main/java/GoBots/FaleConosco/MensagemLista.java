package GoBots.FaleConosco;

public class MensagemLista {
    String listaMensagem(Iterable<Mensagem> lista) {
        String html = "";
        for(Mensagem mensagem : lista) {
            html = html + 
            "Tópico: " + mensagem.getNome() + "<br>" +
            "Mensagem tratada: " +  mensagem.getMensagemEnviada() + "<br>" +
            "Número de identificação: " + mensagem.getId() + "<br>" + "<br>";
        }
        return html;
    }
}


      
        
