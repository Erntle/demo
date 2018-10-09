package concert.demo.entity;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Getter @Setter
@Table(name="Concert")
public class Concert {

    @Id
    @SequenceGenerator(name="concert_seq",sequenceName="concert_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="concert_seq")  
    @Column(name = "Concert_ID", unique = true, nullable = true)
    
    private @NonNull Long id;
    private  @NonNull String concertName;
    private  @NonNull String concertDate;
    private  @NonNull String concertPlace;
    private  @NonNull String concertTime;
    private  @NonNull int concertTicketPrice;

    @OneToMany(         
        mappedBy = "concert",         
        cascade = CascadeType.ALL,         
        orphanRemoval = true)     
        @JsonIgnore
        private List<Ticket> ticket = new ArrayList<>(); 
 
    @ManyToOne
    @JoinColumn(name = "artist_id")     
    private Artist artist; 
}