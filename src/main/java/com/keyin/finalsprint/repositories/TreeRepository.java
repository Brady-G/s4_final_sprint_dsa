package com.keyin.finalsprint.repositories;

import com.keyin.finalsprint.models.TreeEntry;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends ListCrudRepository<TreeEntry, Long> {
}
