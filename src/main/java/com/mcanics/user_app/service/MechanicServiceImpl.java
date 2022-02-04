package com.mcanics.user_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcanics.user_app.data.models.Mechanic;
import com.mcanics.user_app.data.payloads.request.MechanicRequest;
import com.mcanics.user_app.data.payloads.response.MechanicMessageResponse;
import com.mcanics.user_app.data.repository.MechanicRepository;
import com.mcanics.user_app.exception.ResourceNotFoundException;

@Service
public class MechanicServiceImpl implements MechanicService {

	@Autowired
	MechanicRepository mechanicRepository;

	@Override
	public MechanicMessageResponse createMechanic(MechanicRequest mechanicRequest) {
		Mechanic newMechanic = new Mechanic();
		newMechanic.setFirstName(mechanicRequest.getFirstName());
		newMechanic.setLastName(mechanicRequest.getLastName());
		newMechanic.setEmail(mechanicRequest.getEmail());
		newMechanic.setPassword(mechanicRequest.getPassword());
		newMechanic.setAdharNumber(mechanicRequest.getAdharNumber());
		newMechanic.setMobileNumber(mechanicRequest.getMobileNumber());

		mechanicRepository.save(newMechanic);
		return new MechanicMessageResponse("New mechanic created successfully");

	}

	@Override
	public Optional<Mechanic> updateMechanic(Integer mechanicId, MechanicRequest mechanicRequest) {
		Optional<Mechanic> mechanic = mechanicRepository.findById(mechanicId);
		if (mechanic == null) {
			throw new ResourceNotFoundException("Mechanic", "id", mechanicId);
		} else
			mechanic.get().setFirstName(mechanicRequest.getFirstName());
		mechanic.get().setLastName(mechanicRequest.getLastName());
		mechanic.get().setEmail(mechanicRequest.getEmail());
		mechanic.get().setPassword(mechanicRequest.getPassword());
		mechanic.get().setMobileNumber(mechanicRequest.getMobileNumber());
		mechanic.get().setAdharNumber(mechanicRequest.getAdharNumber());

		mechanicRepository.save(mechanic.get());
		return mechanic;

	}

	@Override
	public void deleteMechanic(Integer mechanicId) {
		if (mechanicRepository.getById(mechanicId).getId().equals(mechanicId)) {
			mechanicRepository.deleteById(mechanicId);
		} else
			throw new ResourceNotFoundException("Mechanic", "id", mechanicId);

	}

	@Override
	public Mechanic getASingleMechanic(Integer mechanicId) {
		return mechanicRepository.findById(mechanicId)
				.orElseThrow(() -> new ResourceNotFoundException("Mechanic", "id", mechanicId));
	}

	@Override
	public List<Mechanic> getAllMechanic() {
		return mechanicRepository.findAll();
	}

	@Override
	public Optional<Mechanic> showMechanicByEmailId(String email) {

		return mechanicRepository.findByEmail(email);
	}

	@Override
	public Optional<Mechanic> showMechanicByAdharNumber(String adharNumber) {
		return mechanicRepository.findByAdharNumber(adharNumber);
	}

	@Override
	public Optional<Mechanic> showMechanicByFirstName(String firstName) {
		return mechanicRepository.findByFirstName(firstName);

	}

	
	  @Override
	  public Optional<Mechanic> showMechanicByMobileNumber(String mobileNumber)
	  {
	  
	  return mechanicRepository.findByMobileNumber(mobileNumber); 
	  }
	 

}
