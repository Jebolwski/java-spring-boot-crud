package com.jebolwski.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/customers")
public class LearningApplication {
	private final CustomerRepository customerRepository;
	private final ProductRepository productRepository;

	public LearningApplication(CustomerRepository customerRepository, ProductRepository productRepository) {
		this.customerRepository = customerRepository;
		this.productRepository = productRepository;
	}



	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}

	@GetMapping("/")
	public String Greet(){
		return "Hi mom!";
	}

	record MessageResponse(String message){}

	@GetMapping("/message")
	public MessageResponse Message(){
		return new MessageResponse("ronaldo");
	}

	@GetMapping("/all")
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}

	record AddCustomerView(String name,String email,Integer age,List<Product> products){}

	@PostMapping("/add")
	public boolean addCustomer(@RequestBody AddCustomerView customerview){
		System.out.println(customerview);
		List<Product> products =  customerview.products();
		System.out.println(products);
		for (Product product:products) {
			productRepository.save(product);
		}
		Customer customer = new Customer();
		customer.setAge(customerview.age());
		customer.setName(customerview.name());
		customer.setEmail(customerview.email());
		customer.setProducts(customerview.products());
		var result = customerRepository.save(customer);
		return true;
	}

	@DeleteMapping("/{customerId}/delete")
	public boolean deleteCustomer(@PathVariable("customerId") Integer id){

		Optional<Customer> customer = customerRepository.findById(id);

		if (customer.isPresent()){
			for (Product product:customer.get().getProducts()
			 ) {
				productRepository.delete(product);
			}
			customerRepository.deleteById(id);
			return true;
		}else{
			return false;
		}
	}

}
