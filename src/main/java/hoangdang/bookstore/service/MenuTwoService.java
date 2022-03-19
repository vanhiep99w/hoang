package hoangdang.bookstore.service;

import java.util.List;
import hoangdang.bookstore.entity.MenuTwo;
import hoangdang.bookstore.model.Nav2Model;

public interface MenuTwoService {

	Nav2Model createNav2(Nav2Model nav2Model);

	List<MenuTwo> findAll();

	void delete(Integer id);

	Nav2Model getOneNav2ById(Integer id);

	Nav2Model updateNav2(Nav2Model nav2Model);

}
