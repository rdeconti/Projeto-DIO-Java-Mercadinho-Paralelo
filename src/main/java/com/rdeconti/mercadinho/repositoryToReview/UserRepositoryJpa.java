package com.rdeconti.mercadinho.repositoryToReview;

import com.rdeconti.mercadinho.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserModel, Long> {
    UserModel findByUser_Email(String user_email);
    UserModel findByUser_Name(String user_name);
}