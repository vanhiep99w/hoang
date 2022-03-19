package hoangdang.bookstore.service;

import java.util.List;

import hoangdang.bookstore.entity.Comment;
import hoangdang.bookstore.model.CommentModel;

public interface CommentService {

	List<Comment> getListCommentByProductId(Integer id);

	CommentModel createComment(CommentModel commentModel);

	List<Comment> getListCommentPending();

	Comment getCommentByCommentId(Integer id);

	void approveComment(Integer id);

	void delete(Integer id);

	List<Comment> getListCommentChecked();

	int getCountCommentByProductNameSearch(String nameSearch);

	int getAllStarCommentByProductNameSearch(String nameSearch);

}
