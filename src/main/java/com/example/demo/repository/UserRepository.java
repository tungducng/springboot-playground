package com.example.demo.repository;

import com.example.demo.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//anotation
//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    //findByUserNameAndUserEmail
    //UserNameAndUserEmail
    //userNameAndUserEmail
    //userNameAnduserEmail
    //userName= ?1 and UserEmail = ?1
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    //username
    UserEntity findByUserName(String userName);

    /**
     * WHERE userName LIKE %?
     */
    List<UserEntity> findByUserNameStartingWith(String userName);

    /**
     * WHERE userName LIKE ?%
     */
    List<UserEntity> findByUserNameEndingWith(String userName);

    /**
     * WHERE id < 1
     */
    List<UserEntity> findByIdLessThan(Long id);

    //RAW JPQL
    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX(p.id) FROM UserEntity p)")
    UserEntity findMaxIdUser();

    /**
     * UPDATE delete
     * @param userName
     * @return
     */
    @Modifying
    @Query("UPDATE UserEntity u SET u.userName = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    //native query
    @Query(value = "SELECT COUNT(id) FROM java_user_01", nativeQuery = true)
    long getTotalUser();
}
