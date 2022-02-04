package com.lawstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lawstorage.law.Law;



public interface LawStorageRepository extends JpaRepository <Law, Long> {

}
