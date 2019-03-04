package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
