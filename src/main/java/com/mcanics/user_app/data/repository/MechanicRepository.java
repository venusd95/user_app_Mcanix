package com.mcanics.user_app.data.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcanics.user_app.data.models.Mechanic;
@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {
	 Optional<Mechanic> findByEmail(String email);

		Optional<Mechanic> findByAdharNumber(String adharNumber); 
		Optional<Mechanic> findByFirstName(String firstName); 
		Optional<Mechanic> findByMobileNumber(String mobileNumber);
}
