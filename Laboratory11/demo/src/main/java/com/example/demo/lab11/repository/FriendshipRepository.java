package com.example.demo.lab11.repository;

import com.example.demo.lab11.entity.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {

    @Query("SELECT f FROM Friendship f WHERE f.id=?1")
    Optional<Friendship> findFriendshipById(Integer id);
}
