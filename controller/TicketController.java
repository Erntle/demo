package concert.demo.controller;

import concert.demo.entity.Ticket;
import concert.demo.entity.Concert;
import concert.demo.entity.Customer;
import concert.demo.repository.TicketRepository;
import concert.demo.repository.ConcertRepository;
import concert.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TicketController {
    @Autowired   private TicketRepository ticketRepository;
    @Autowired   private ConcertRepository concertRepository;
    @Autowired   private CustomerRepository customerRepository;

    @GetMapping("/Ticket")
    public Collection<Ticket> Ticket() {
        return ticketRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Ticket/{concertId}")
    public Optional<Ticket> Ticket(@PathVariable Long concertId) {
        Optional<Ticket> Ticket = ticketRepository.findById(concertId);
        return Ticket;
    }

    @PostMapping("/Ticket/{username}/{concertName}")
    public Ticket newTicket(Ticket newTicket,@PathVariable String username,@PathVariable String concertName) {   

        Customer cus = customerRepository.findByUsername(username);
        Concert con  = concertRepository.findByConcertName(concertName);

        newTicket.setCustomer(cus);
        newTicket.setConcert(con);

        return ticketRepository.save(newTicket);
    }
}