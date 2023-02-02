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

import springapi.springapp.dto.CustomerDTO;
import springapi.springapp.service.CustomerService;

@RestController
@RequestMapping(value = "v1")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping("/")
    public String home() {
            return "Hello World!";
    }
    
    @GetMapping(value = "/all")
    public ArrayList<CustomerDTO> getAllCustomers(){
        return customerService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") Long customerId){
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteCustomer(@PathVariable("id") Long customerId){
        return customerService.delete(customerId);
    }

    @PostMapping("/save")
    public boolean saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.save(customerDTO);
    }
}
