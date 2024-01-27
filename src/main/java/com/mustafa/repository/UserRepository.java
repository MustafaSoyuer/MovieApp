package com.mustafa.repository;

import com.mustafa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findOptionalByEmailAndPassword(String email,String password);

//    Kullanıcıları ismine göre sıralayan bir metot yazınız.
    List<User> findAllByOrderByName();

//    Kullanıcının girdiği bir isimle veritabanındaki bir ismin var olup olmadığını karşılaştırınız.
    Boolean existsByNameIgnoreCase(String name);

//    Kullanıcının isim sorgulaması için girdiği harf veya kelimeye göre veritabanında sorgu yapan bir metot yazınız.
    List<User> findAllByNameContainingIgnoreCase(String name);

//     Kullanıcının girdiği email'e göre veritabanında sorgu yapan bir metot yazınız.
    Optional<User> findByEmail(String email);


}
