package com.storagelaw;

import org.springframework.data.repository.CrudRepository;

public interface LawRepository extends CrudRepository<Law, Long> {

    public void findAllByLawId(Long lawId);

}
