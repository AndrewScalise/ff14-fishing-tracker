package com.mugen.ff14fishingtracker.users.models.dao;

import com.mugen.ff14fishingtracker.users.models.Fish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Mugen on 7/10/2017.
 */
public interface FishDao extends CrudRepository<Fish, Integer> {

    List<Fish> findByAuthor(int authorId);

    Fish findByUid(int uid);

}
