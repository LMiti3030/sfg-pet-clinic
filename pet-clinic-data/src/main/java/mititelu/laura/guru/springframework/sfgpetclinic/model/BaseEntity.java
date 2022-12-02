package mititelu.laura.guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
