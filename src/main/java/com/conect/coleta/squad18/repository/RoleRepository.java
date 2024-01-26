package com.conect.coleta.squad18.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conect.coleta.squad18.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByAuthority(String authority);

}
