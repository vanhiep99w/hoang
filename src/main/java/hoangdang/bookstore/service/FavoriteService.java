package hoangdang.bookstore.service;

import java.util.List;

import hoangdang.bookstore.entity.Favorite;
import hoangdang.bookstore.model.BestSellerModel;
import org.springframework.data.domain.Pageable;

public interface FavoriteService {

	Favorite create(int id);

	List<Favorite> getListFavoriteByEmail();

	void delete(int id);

	Favorite getOneFavorite(int id);

	List<BestSellerModel> getListBestSellerProduct(Pageable topFour);

}
