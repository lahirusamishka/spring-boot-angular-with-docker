package springapi.springapp.service;

import java.util.ArrayList;

import springapi.springapp.dto.CustomerDTO;

public interface CustomerService {
	
    ArrayList<CustomerDTO> getAll();

    CustomerDTO getCustomer(Long id);

    boolean delete(Long customerId);

    boolean save(CustomerDTO customerDTO);

}
