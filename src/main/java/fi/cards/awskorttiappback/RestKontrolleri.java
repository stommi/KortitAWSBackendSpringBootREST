package fi.cards.awskorttiappback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RestKontrolleri {
    @Autowired
    PelikorttiRepository pr;

    @GetMapping("/pelikortit")
    public Iterable<Pelikortti> getAll() {
        return pr.findAll();
    }

    @GetMapping("/pelikortit_in_order")
    public Iterable<Pelikortti> getAllCardsInOrder(){
        return pr.getAllCardsInOrder();
    }

    @GetMapping("/jaakasi")
    public List<Pelikortti> jaaKasi() {
        List<Pelikortti> kaikkiKortit = pr.findAllByIdNotNullOrderById();
        List<Pelikortti> kasi = new ArrayList<>();
        Collections.shuffle(kaikkiKortit);

        int i = 0;
        while(kasi.size() < 9) {
            kasi.add(kaikkiKortit.get(i));
            i++;
        }
        return kasi;
    }

}
