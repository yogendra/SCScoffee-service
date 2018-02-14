package com.thehecklers.coffeeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    private final CoffeeRepository coffeeRepository;

    public CoffeeController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping
    Iterable<Coffee> findAllCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    Coffee findCoffeeById(@PathVariable Long id) {
        return coffeeRepository.findOne(id);
    }

    @GetMapping("/random")
    Coffee findRandomCoffee() {
        return coffeeRepository.getCoffeesRandomOrder().iterator().next();
        //return coffeeRepository.getCoffeesRandomOrder().get(0);
    }
}
