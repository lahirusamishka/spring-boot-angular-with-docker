package springapi.springapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springapi.springapp.dto.ContactDTO;
import springapi.springapp.entity.Contact;
import springapi.springapp.repository.ContactRepository;
import springapi.springapp.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository customerRepository;

    @Override
    public ArrayList<ContactDTO> getAll() {

        ArrayList<ContactDTO> customerDTOS = new ArrayList<>();

        List<Contact> customerList = customerRepository.findAll();
        for (Contact customer: customerList) {
            ContactDTO customerDTO = new ContactDTO();

            customerDTO.setId(customer.getId());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setName(customer.getName());
            customerDTO.setContact(customer.getContact());

            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public ContactDTO getCustomer(Long id) {
        Contact customer =  customerRepository.findById(id).get();

        ContactDTO customerDTO = new ContactDTO();

        customerDTO.setId(customer.getId());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setName(customer.getName());
        customerDTO.setContact(customer.getContact());

        return customerDTO;
    }

    @Override
    public boolean delete(Long customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }

    @Override
    public boolean save(ContactDTO customerDTO) {
        Contact customer = new Contact();

        customer.setId(customerDTO.getId());
        customer.setAddress(customerDTO.getAddress());
        customer.setName(customerDTO.getName());
        customer.setContact(customerDTO.getContact());

        customerRepository.save(customer);

        return true;

    }
}
