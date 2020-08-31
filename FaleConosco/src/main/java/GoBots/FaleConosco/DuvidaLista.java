package GoBots.FaleConosco;

public class DuvidaLista {
    String listaDuvida(Iterable<Duvida> lista) {
        String html = "";
        for(Duvida duvida : lista) {
            html = html + "<h1>" +
            duvida.getNome() + "</h1>" +
            duvida.getEmail() + "<br>" +
            duvida.getTopico() + "<br>" +
            duvida.getMensagem() + "<br>" + "<br>";
        }
        return html;
    }
}
