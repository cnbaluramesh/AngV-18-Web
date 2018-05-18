package com.anglia.login.service.autorizacija;

import com.anglia.login.model.autorizacija.Autorizacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorizacijaService extends JpaRepository<Autorizacija, Integer> {
}
