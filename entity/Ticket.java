package concert.demo.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Ticket {
	@Id
	@SequenceGenerator(name="ticket_seq",sequenceName="ticket_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ticket_seq")      
	@Column(name="Ticket_ID")

    private @NonNull Long id;

    @ManyToOne
    @JoinColumn(name = "cus_id")     
    private Customer customer; 
 
    @ManyToOne   
    @JoinColumn(name = "concert_id")     
    private Concert concert;
 
}