package hoangdang.bookstore.service;

import java.util.List;

import hoangdang.bookstore.entity.Manufacturer;
import hoangdang.bookstore.model.ManufacturerModel;

public interface ManufacturerService{

	ManufacturerModel createManufacturer(ManufacturerModel manufacturerModel);

	List<Manufacturer> findAll();

	ManufacturerModel getOneManufacturerById(Integer id);

	void delete(Integer id);

	ManufacturerModel updateManufacturer(ManufacturerModel manufacturerModel);

}
