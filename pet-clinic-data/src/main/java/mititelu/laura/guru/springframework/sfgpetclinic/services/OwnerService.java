package mititelu.laura.guru.springframework.sfgpetclinic.services;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Owner;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public interface OwnerService  extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
