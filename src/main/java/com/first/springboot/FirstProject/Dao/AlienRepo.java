package com.first.springboot.FirstProject.Dao;

import org.springframework.data.repository.CrudRepository;
import com.first.springboot.FirstProject.Model.Alien;

//this repo needs to be type of interface and when it extends CrudRepo it by default gets all the crud operation without implementing anything
// crud repo is generic type so you need to give the model class name on which this repo is going to work on and also the type of primary key as second parameter in generic type 
public interface AlienRepo extends CrudRepository<Alien, Integer> {

}
