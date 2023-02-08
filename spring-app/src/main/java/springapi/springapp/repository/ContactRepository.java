package springapi.springapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import springapi.springapp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long> {
	
}
