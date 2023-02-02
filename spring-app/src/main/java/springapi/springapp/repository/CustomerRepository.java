package springapi.springapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import springapi.springapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
