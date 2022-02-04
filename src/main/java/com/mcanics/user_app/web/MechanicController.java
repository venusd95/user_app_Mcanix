package com.mcanics.user_app.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcanics.user_app.data.models.Mechanic;
import com.mcanics.user_app.data.payloads.request.MechanicRequest;
import com.mcanics.user_app.data.payloads.response.MechanicMessageResponse;
import com.mcanics.user_app.service.MechanicService;

import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/mechanic")
//Line 19 to 24 is the newly added code for swagger documentation
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
public class MechanicController {
	@Autowired
    MechanicService mechanicService;

    @GetMapping("/allmechs")
    public ResponseEntity<List<Mechanic>> getAllMechanics () {
        List<Mechanic> gems = mechanicService.getAllMechanic();
        return new ResponseEntity<>(gems, HttpStatus.OK);
    }
    @GetMapping("/findmech/{id}")
    public ResponseEntity<Mechanic> getMechanicById (@PathVariable("id") Integer id) {
        Mechanic mechanic = mechanicService.getASingleMechanic(id);
        return new ResponseEntity<>(mechanic, HttpStatus.OK);
    }
    @PostMapping("/addmech")
    public ResponseEntity<MechanicMessageResponse> addMechanic( @RequestBody MechanicRequest mechanic) {
        MechanicMessageResponse newMechanic = mechanicService.createMechanic(mechanic);
        return new ResponseEntity<>(newMechanic, HttpStatus.CREATED);
    }

    @PutMapping("/updatemech/{id}")
    public Optional<Mechanic> updateMechanic(@PathVariable Integer id, @RequestBody MechanicRequest mechanic) {
        return mechanicService.updateMechanic(id,mechanic);

    }

    @DeleteMapping("/deletemech/{id}")
    public ResponseEntity<?> deleteMechanic(@PathVariable("id") Integer id) {
        mechanicService.deleteMechanic(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findbyemail/{email}")
	public Optional<Mechanic> displayMechanicByEmail(@PathVariable String email)
	{
		return mechanicService.showMechanicByEmailId(email);
		
	}

	
	  @GetMapping("/findbyadharnumber/{adharNumber}")
	  public Optional<Mechanic>displayMechanicByAdharNumber(@PathVariable String adharNumber) 
	  { 
		  return mechanicService.showMechanicByAdharNumber(adharNumber);
	  
	  }
	 
		
		  @GetMapping("/findbyfirstname/{firstName}") 
		  public Optional<Mechanic>displayMechanicByName(@PathVariable String firstName)
		  {
			  return mechanicService.showMechanicByFirstName(firstName);
		 }
		 
	
	  @GetMapping("/findbymobilenumber/{mobileNumber}")
	  public Optional<Mechanic>displayMechanicByMobileNumber(@PathVariable String mobileNumber) { 
		  return mechanicService.showMechanicByMobileNumber(mobileNumber);
	  
	  }
	 

}
