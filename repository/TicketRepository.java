package concert.demo.repository;

import concert.demo.entity.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TicketRepository extends JpaRepository<Ticket, Long> {

}