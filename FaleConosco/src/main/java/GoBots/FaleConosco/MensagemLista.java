/**
 * Retorna a lista completa de todas as mensagens
 */
package GoBots.FaleConosco;

public class MensagemLista {
    String listaMensagem(Iterable<Mensagem> lista) {
        String html = "";
        for(Mensagem mensagem : lista) {
            html = html + "<div style=\"font-size:18px; padding-left: 470px; font-family: 'Poppins', sans-serif; color: #4054B2;\">"+
            "<b>Tópico: </b>" + mensagem.getNome() + "<br>" +
            "<b>Mensagem: </b>" +  mensagem.getMensagemEnviada() + "<br>" +
            "<b>Número de identificação: </b>" + mensagem.getId() + "<br>" + "<br>" + "</div>";
        }
        return html;
    }
}


      
        
