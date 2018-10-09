package concert.demo.entity;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter @Setter
@Table(name="Artist")

public class Artist {
    @Id
    @GeneratedValue

    private int artistId;
    private String artistName;

    @OneToMany(
        mappedBy = "artist",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
        @JsonIgnore
    private List<Artist> artist = new ArrayList<>();

    public void setartistId(int artistId) {
        artistId = artistId;
    }
    public int getartistId() {
        return artistId;
    }

    public void setartistName(String artistName) {
        artistName = artistName;
    }
    public String getartistName() {
        return artistName;
    }
    protected Artist() {}
    public Artist(String artistName , int artistId) {
        this.artistName = artistName;
        this.artistId = artistId;
    }
}

