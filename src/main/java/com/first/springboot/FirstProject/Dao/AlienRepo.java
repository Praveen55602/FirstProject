package com.first.springboot.FirstProject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.first.springboot.FirstProject.Model.Alien;

//this repo needs to be type of interface and when it extends CrudRepo it by default gets all the crud operation without implementing anything
// crud repo is generic type so you need to give the model class name on which this repo is going to work on and also the type of primary key as second parameter in generic type 
// we can create our own function inside this but we can't write there implementation as its an interface but we can write JPQL queries
// we also have some other inbuild helper functions which we can use we just need to follow some protocol while creating them
// here we've changed crud repo to jpa for some additional features jpa repo in terns extends crud repo so those features are also there
// the reason to change from crud to jpa was because findAll() in crud gives you iterable while jpa gives you List<> which is better
public interface AlienRepo extends JpaRepository<Alien, Integer> {
    // this will automatically work but we have to follow the rules start with
    // findBy and add attribute by which you want to find in camel case
    List<Alien> findByLang(String lang);

    List<Alien> findByAidGreaterThan(int aid); // both of these are inbuild

    // this is a custom function so we've to give a JPQL query here ?1 is
    // placeholder for the argument that will be passed in the function
    // since this is JPQL name of table or model should match name of class
    @Query("from Alien where lang=?1 order by alienName")
    List<Alien> findByLangSorted(String lang);
}
