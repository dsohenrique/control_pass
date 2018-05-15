package br.com.controlpass.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDAO<T> extends JpaRepository<T, Long> {

	
}
