package mititelu.laura.guru.springframework.sfgpetclinic.services;

import java.util.Set;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T t);

    void delete( T t);

    void deleteById(ID id);

}
