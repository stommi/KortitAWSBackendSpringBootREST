package fi.cards.awskorttiappback;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Pelikortti {

    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "pelikortti_id_seq")
    @SequenceGenerator(name = "pelikortti_id_seq",
            sequenceName = "pelikortti_id_seq",
            allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String maa;
    private int arvo;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaa() {
        return maa;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    public int getArvo() {
        return arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Pelikortti{" +
                "id=" + id +
                ", maa='" + maa + '\'' +
                ", arvo=" + arvo +
                ", url='" + url + '\'' +
                '}';
    }
}
