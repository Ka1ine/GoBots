package GoBots.FaleConosco;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface DuvidaRepository extends CrudRepository<Duvida, Integer> {
    @Query(value = "SELECT * FROM duvida duvida WHERE duvida.telefone >= :telefone", nativeQuery = true)
    Iterable<Duvida> findDuvida(@Param("telefone")Integer telefone);
}
