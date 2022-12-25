package com.rupesh.service;

import com.rupesh.entity.Address;
import com.rupesh.model.AddressDTO;
import com.rupesh.repository.AddressRepository;
import com.rupesh.util.global.GlobalResponse;
import com.rupesh.util.global.GlobalUtil;
import com.rupesh.util.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;
    public static final String ADDRESS_BY_USER_ID_NOT_FOUND = "no address assign to user with user id ['%s'].";
    public static final String ADDRESS_FOUND_SUCCESS = "address to user with user id ['%s'] fetch successfully.";
    public static final String ADDRESS_SAVED_SUCCESS = "address saved successfully.";

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public GlobalResponse<AddressDTO> getByUserId(final String userId) {
        final AddressDTO address = addressRepository
                .getByUserId(userId)
                .map(AddressMapper::toDTO)
                .orElseThrow(() ->
                        new RuntimeException(String.format(ADDRESS_BY_USER_ID_NOT_FOUND, userId)));

        return GlobalUtil
                .globalResponse(
                        String.format(ADDRESS_FOUND_SUCCESS, userId),
                        HttpStatus.OK,
                        address
                );
    }

    @Override
    public GlobalResponse<AddressDTO> saveAddress(final AddressDTO addressDTO) {
        final Address address = AddressMapper.toEntity(addressDTO);
        address.setCreatedDate(LocalDateTime.now());
        address.setCreatedBy(addressDTO.getUserId());

        return GlobalUtil
                .globalResponse(
                        ADDRESS_SAVED_SUCCESS,
                        HttpStatus.OK,
                        Optional.ofNullable(addressRepository.save(address))
                                .map(AddressMapper::toDTO)
                                .orElse(null)
                );
    }
}
