package mititelu.laura.guru.springframework.sfgpetclinic.model;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public class Person extends BaseEntity{

    private String firstName;

    private String lastName;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
