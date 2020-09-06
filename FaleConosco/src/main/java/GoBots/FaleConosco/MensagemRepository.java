/**
 * Filtra e trata as mensagens
 */
package GoBots.FaleConosco;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MensagemRepository extends CrudRepository<Mensagem, Integer> {
    @Query(value = "SELECT * FROM mensagem mensagem WHERE mensagem.nome = :nome", nativeQuery = true)
    Iterable<Mensagem> findMensagem(@Param("nome")String nome);

    @Query(value = "SELECT mensagemTratada FROM gobots WHERE internetes = :mensagemEnviada" , nativeQuery = true)
    Iterable<String>findTraducao(@Param("mensagemEnviada")String mensagemEnviada);
}