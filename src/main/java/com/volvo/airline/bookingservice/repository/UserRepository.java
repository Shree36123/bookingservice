package com.volvo.airline.bookingservice.repository;

import com.volvo.airline.bookingservice.model.Gender;
import com.volvo.airline.bookingservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("""
            update User u set u.firstName = ?1, u.lastName = ?2, u.phoneNumber = ?3, u.gender = ?4, u.userName = ?5, u.password = ?6
            where u.id = ?7""")
    int updateFirstNameAndLastNameAndPhoneNumberAndGenderAndUserNameAndPasswordById(String firstName, String lastName, Long phoneNumber, Gender gender, String userName, String password, Object unknownAttr1);
}
