package com.rupesh.resource;

import com.rupesh.model.AddressDTO;
import com.rupesh.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/address")
public class AddressResource {

    private final AddressService addressService;

    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveAddress(@RequestBody final AddressDTO addressDTO) {
        return new ResponseEntity(addressService.saveAddress(addressDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAddressByUserId(@PathVariable final String userId) {
        return ResponseEntity.ok(addressService.getByUserId(userId));
    }

}
