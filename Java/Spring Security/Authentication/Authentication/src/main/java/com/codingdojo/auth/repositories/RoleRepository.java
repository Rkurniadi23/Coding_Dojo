package com.codingdojo.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.auth.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
