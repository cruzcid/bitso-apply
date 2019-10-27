package com.bitso.challenge.model.ram;

import com.bitso.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
