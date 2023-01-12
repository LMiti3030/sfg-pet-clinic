package mititelu.laura.guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public class Owner extends Person{

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
