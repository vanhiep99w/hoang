package hoangdang.bookstore.service;

import java.util.List;

import hoangdang.bookstore.entity.InformationShop;
import hoangdang.bookstore.model.ShopModel;

public interface InformationShopService {

	ShopModel createInformationShop(ShopModel shopModel);

	List<InformationShop> findAll();

	void delete(Integer id);

	ShopModel updateActive(ShopModel shopModel);

	ShopModel getOneShopById(Integer id);

	ShopModel updateInformation(ShopModel shopModel);

	InformationShop getOneInformationShop();

}
