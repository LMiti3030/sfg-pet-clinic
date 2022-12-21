package mititelu.laura.guru.springframework.sfgpetclinic.services.map;

import mititelu.laura.guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public abstract class AbstractMapService <T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findByID(ID id){
        return map.get(id);
    }

    T save (T object){
        if(object != null){
            if(object.getId() == null ){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void delete(T object){
       map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id){
        map.remove(id);
    }

    private Long getNextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1;//gets the maximum of the keys in the map and adds 1
        } catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }

}
