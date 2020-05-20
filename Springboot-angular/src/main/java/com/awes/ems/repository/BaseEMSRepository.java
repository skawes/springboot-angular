package com.awes.ems.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.awes.ems.entity.Auditable;

@NoRepositoryBean
public interface BaseEMSRepository<T extends Auditable, ID> extends JpaRepository<T, ID> {
	Page<T> findByActiveTrue(Pageable pageable);

	List<T> findByActiveTrue();

}
