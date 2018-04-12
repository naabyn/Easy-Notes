package com.nabin.eassynotess.Repository;

import com.nabin.eassynotess.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{
}
