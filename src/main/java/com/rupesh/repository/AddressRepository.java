package com.rupesh.repository;

import com.rupesh.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(nativeQuery = true,
            value = "select addr.id, addr.country, addr.city, addr.zone, addr.street, addr.user_id, addr.created_by, addr.created_date, addr.modified_by, addr.modified_date from address addr where addr.user_id = ?1")
    Optional<Address> getByUserId(String userId);

}
