
package ru.innopolis.jpademo.service;

import org.springframework.stereotype.Service;
import ru.innopolis.jpademo.model.Users;
import ru.innopolis.jpademo.repository.UsersRepository;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepository customerRepository;

    public UsersService(UsersRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Users> getCustomers() {
        return customerRepository.findAll();
    }

    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }
}
