package com.mcanics.user_app.data.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcanics.user_app.data.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
