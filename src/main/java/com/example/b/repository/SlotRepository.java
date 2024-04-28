package com.example.b.repository;

import com.example.b.dto.Slot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepository<slot> extends CrudRepository<slot, String> {

}
