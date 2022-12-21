package mititelu.laura.guru.springframework.sfgpetclinic.services.map;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Vet;
import mititelu.laura.guru.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(),vet);
    }
}
