package com.mustafa.repository;

import com.mustafa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

// burada maxLength den önce boşluk bıraktığım için hata veriyordu hocam.bir tane boşluk :)
    @Query(value = "select * from tbl_user as u where length(u.password) > :maxLength", nativeQuery = true)
    List<User> findUsersWithLongPasswordNative(@Param("maxLength") Integer length);


    @Query("SELECT u FROM User u WHERE LENGTH(u.password) > ?1")
    List<User> findUsersWithLongPasswordJPQL(int passwordLength);

//    emailin sonu kullanıcının girdiği değerlere göre biten emailleri listeleyiniz.
    List<User> findAllByEmailEndsWithIgnoreCase(String name);



}
