package com.mugen.ff14fishingtracker.users.models.dao;

import com.mugen.ff14fishingtracker.users.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Mugen on 7/10/2017.
 */
@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUid(int uid);

    List<User> findAll();

    User findByUsername(String username);
}
