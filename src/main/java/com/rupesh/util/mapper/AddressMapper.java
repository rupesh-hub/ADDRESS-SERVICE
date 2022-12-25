package com.rupesh.util.mapper;

import com.rupesh.entity.Address;
import com.rupesh.model.AddressDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper {

    public static AddressDTO toDTO(final Address source) {

        final AddressDTO addressDTO = new AddressDTO();

        addressDTO.setUserId(source.getUserId());
        addressDTO.setCountry(source.getCountry());
        addressDTO.setZone(source.getZone());
        addressDTO.setCity(source.getCity());
        addressDTO.setStreet(source.getStreet());
        addressDTO.setCreatedBy(source.getCreatedBy());
        addressDTO.setCreatedDate(source.getCreatedDate());
        addressDTO.setModifiedBy(source.getModifiedBy());
        addressDTO.setModifiedDate(source.getModifiedDate());

        return addressDTO;
    }

    public static Address toEntity(final AddressDTO source) {
        final Address address = new Address();

        address.setUserId(source.getUserId());
        address.setCountry(source.getCountry());
        address.setZone(source.getZone());
        address.setCity(source.getCity());
        address.setStreet(source.getStreet());
        address.setCreatedBy(source.getCreatedBy());
        address.setCreatedDate(source.getCreatedDate());
        address.setModifiedBy(source.getModifiedBy());
        address.setModifiedDate(source.getModifiedDate());

        return address;
    }

    public static List<AddressDTO> toDTOList(final List<Address> addressList) {
        return addressList.stream().map(AddressMapper::toDTO).collect(Collectors.toList());
    }

}
