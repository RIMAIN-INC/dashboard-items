package io.orangetech.fruits;


import jakarta.annotation.security.RolesAllowed;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.transaction.Transactional;

import java.util.List;


@WebService(
        name="io.orangetech.fruits.FruitService",
        serviceName = "io.orangetech.fruits.FruitService"
)
public interface FruitService {

    @WebMethod
    List<Fruit> getAllFruits();


    @WebMethod
    Fruit getFruit(long id);

    @WebMethod
    Fruit addFruit(FruitRequest fruitRequest);

    @WebMethod
    Fruit updateFruit(long id, FruitRequest fruitRequest);

    @WebMethod
    @Transactional
    void deleteFruit(long id);


}
