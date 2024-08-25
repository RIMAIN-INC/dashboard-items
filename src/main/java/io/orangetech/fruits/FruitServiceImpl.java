package io.orangetech.fruits;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import jakarta.transaction.Transactional;

import java.util.List;
@WebService(
        name="io.orangetech.fruits.FruitServiceImpl",
        serviceName="io.orangetech.fruits.FruitServiceImpl"
)
public class FruitServiceImpl implements FruitService{

    @Inject
    FruitRepository fruitRepository;


    @Override
    public List<Fruit> getAllFruits(){
        return fruitRepository.findAll().stream().toList();
    }

    @Override
    public Fruit getFruit(long id) {
        Fruit fruit = fruitRepository.findById(id);
        if (fruit == null){
            throw new RuntimeException();
        }
        return fruit;

    }


    @Override
    @Transactional
    @RolesAllowed("USER")
    public Fruit addFruit(FruitRequest fruitRequest) {
        Fruit fruit = new Fruit();
        fruit.setColor(fruitRequest.getColor());
        fruit.setName(fruitRequest.getName());
        fruit.setQuantity(fruitRequest.getQuantity());
        fruitRepository.persist(fruit);
        return fruit;
    }

    @Override
    @Transactional
    public Fruit updateFruit(long id, FruitRequest fruitRequest) {
        Fruit fruit = fruitRepository.findById(id);
        if (fruit == null){
            throw new RuntimeException();
        }
        fruit.setName(fruitRequest.getName());
        fruit.setName(fruitRequest.getName());
        fruit.setQuantity(fruitRequest.getQuantity());
        fruit.setColor(fruitRequest.getColor());
        fruitRepository.persist(fruit);

        return fruit;
    }

    @Override
    @Transactional
    public void deleteFruit(long id) {
        Fruit fruit = fruitRepository.findById(id);
        if (fruit == null){
            throw new RuntimeException();
        }
        fruitRepository.deleteById(id);
    }


}