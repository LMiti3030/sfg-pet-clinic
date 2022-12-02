package mititelu.laura.guru.springframework.sfgpetclinic.model;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public class PetType extends BaseEntity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
