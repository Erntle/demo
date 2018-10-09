package concert.demo.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@Table(name="Customer")
public class Customer {
	@Id
	@SequenceGenerator(name="cus_seq",sequenceName="cus_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cus_seq")      
	@Column(name="CUS_ID",unique = true, nullable = true)
	private @NonNull Long id;
    private @NonNull String username;
	private @NonNull String password;

	@OneToMany(         
		mappedBy="customer",         
		cascade = CascadeType.ALL,         
		orphanRemoval = true)     
	@JsonIgnore
		private List<Ticket> ticket = new ArrayList<>(); 

}