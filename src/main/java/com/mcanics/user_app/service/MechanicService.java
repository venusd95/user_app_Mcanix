package com.mcanics.user_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mcanics.user_app.data.models.Mechanic;
import com.mcanics.user_app.data.payloads.request.MechanicRequest;
import com.mcanics.user_app.data.payloads.response.MechanicMessageResponse;





@Component
public interface MechanicService {
	MechanicMessageResponse createMechanic(MechanicRequest mechanicRequest);
	Optional<Mechanic>updateMechanic(Integer mechanicId,MechanicRequest mechanicRequest);
     void deleteMechanic(Integer mechanicId);
    Mechanic getASingleMechanic(Integer mechanicId);
    List<Mechanic>getAllMechanic();
    Optional<Mechanic>showMechanicByEmailId(String email);

	 Optional<Mechanic>showMechanicByAdharNumber(String adharNumber); 
	 Optional<Mechanic>showMechanicByFirstName(String firstName);
	Optional<Mechanic>showMechanicByMobileNumber(String mobileNumber);
}
