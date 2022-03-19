package hoangdang.bookstore.service;

import java.util.List;

import hoangdang.bookstore.entity.Address;
import hoangdang.bookstore.entity.District;
import hoangdang.bookstore.entity.Province;
import hoangdang.bookstore.entity.Ward;
import hoangdang.bookstore.model.AddressModel;

public interface AddressService {	
	List<Address> findListAddressByEmail(String username);
	List<Province> findAllProvince();
	List<District> findDistrictByIdProvince(Integer id);
	List<Ward> findWardByIdProvinceAndIdDistrict(Integer idProvince, Integer idDistrict);
	AddressModel createAddress(AddressModel addressModel);
	Address getAddressById(int parseInt);
	void delete(Address address);
	Address findAddressById(String username, int id);
	AddressModel getOneAddressById(int id);
	List<District> getListDistrictByAdressId(Integer id);
	List<Ward> getListWardByAdressId(Integer id);
	AddressModel updateAddress(AddressModel addressModel, Integer id);
}
