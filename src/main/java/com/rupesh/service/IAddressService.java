package com.rupesh.service;

import com.rupesh.model.AddressDTO;
import com.rupesh.util.global.GlobalResponse;

public interface IAddressService {

    GlobalResponse<AddressDTO> saveAddress(final AddressDTO addressDTO);

    GlobalResponse<AddressDTO> getByUserId(final String userId);

}
