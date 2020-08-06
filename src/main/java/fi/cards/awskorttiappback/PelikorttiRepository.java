package fi.cards.awskorttiappback;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PelikorttiRepository extends CrudRepository<Pelikortti, Integer> {
    List<Pelikortti> findAllByIdNotNullOrderById();

    @Query("SELECT p FROM Pelikortti p ORDER BY p.maa, p.arvo")
    Iterable<Pelikortti> getAllCardsInOrder();
}
