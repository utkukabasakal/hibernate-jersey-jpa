package com.ex.dao;

import javax.jws.WebParam;
import java.util.List;

public interface CrudRepository<Model, ID> {

    Model findbyId(ID id);

    List<Model> findAll();

    void insert(Model model);

    void deleteById(ID id);

    void delete(Model model);

    void update(Model model);
}