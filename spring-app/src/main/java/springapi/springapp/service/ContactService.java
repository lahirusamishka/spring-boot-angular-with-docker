package springapi.springapp.service;

import java.util.ArrayList;

import springapi.springapp.dto.ContactDTO;

public interface ContactService {
	
    ArrayList<ContactDTO> getAll();

    ContactDTO getCustomer(Long id);

    boolean delete(Long customerId);

    boolean save(ContactDTO customerDTO);

}
