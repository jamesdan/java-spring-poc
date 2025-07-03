package com.jamesdan.java_spring_poc.service;

import com.jamesdan.java_spring_poc.model.UserAccount;
import com.jamesdan.java_spring_poc.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
@Service
public class CRUDService {
    private final UserAccountRepository userAccountRepository;

    public String create(String name, int age) {
        if (userAccountRepository.findAll().stream().anyMatch(userAccount -> userAccount.getName().equals(name))) {
            return "User with name " + name + " already exists in Java Spring POC by CRUDService";
        }

        UserAccount userAccount = new UserAccount();
        userAccount.setName(name);
        userAccount.setAge(age);
        userAccountRepository.save(userAccount);
        return "Hello " + name + "! Welcoming you in Java Spring POC by CRUDService";
    }

    public String read(Long id) {
        AtomicReference<String> response = new AtomicReference<>("User with ID " + id + " not found in Java Spring POC by CRUDService");
        userAccountRepository.findById(id).ifPresent(userAccount -> response.set("Hello " + userAccount.getName() + "! age [" + userAccount.getAge() + "] You are in Java Spring POC by CRUDService"));
        return response.get();
    }

    public String update(String name, int age) {
        var user = userAccountRepository.findAll().stream().filter(u -> u.getName().equals(name)).findFirst();
        if (user.isEmpty()) {
            return "User with name " + name + " not found in Java Spring POC by CRUDService";
        }
        UserAccount existingUserAccount = user.get();
        existingUserAccount.setAge(age);
        userAccountRepository.save(existingUserAccount);
        return "Hello " + name + "! You have been updated in Java Spring POC by CRUDService";
    }

    public String delete(String name) {
        var user = userAccountRepository.findAll().stream().filter(u -> u.getName().equals(name)).findFirst();
        if (user.isEmpty()) {
            return "User with name " + name + " not found in Java Spring POC by CRUDService";
        }
        userAccountRepository.delete(user.get());
        return "Goodbye " + name + "! You have been removed from Java Spring POC by CRUDService";
    }
}
