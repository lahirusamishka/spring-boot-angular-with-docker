package springapi.springapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springapi.springapp.dto.ContactDTO;
import springapi.springapp.service.ContactService;

@RestController
@RequestMapping(value = "v1")
public class ContactController {
    
    @Autowired
    private ContactService contactService;
    
    @GetMapping("/")
    public String home() {
            return "Hello World!";
    }
    
    @GetMapping(value = "/all")
    public ArrayList<ContactDTO> getAllCustomers(){
        return contactService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ContactDTO getCustomerById(@PathVariable("id") Long customerId){
        return contactService.getCustomer(customerId);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteCustomer(@PathVariable("id") Long customerId){
        return contactService.delete(customerId);
    }

    @PostMapping("/save")
    public boolean saveCustomer(@RequestBody ContactDTO customerDTO){
        return contactService.save(customerDTO);
    }
}
