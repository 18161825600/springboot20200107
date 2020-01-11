package com.example.springboot20200107.service.impl;

import com.example.springboot20200107.dao.CommentDao;
import com.example.springboot20200107.dao.ScenicSpotDao;
import com.example.springboot20200107.dao.UserDao;
import com.example.springboot20200107.pojo.Comment;
import com.example.springboot20200107.pojo.ScenicSpot;
import com.example.springboot20200107.pojo.User;
import com.example.springboot20200107.request.AddCommentRequest;
import com.example.springboot20200107.request.UpdateCommentRequest;
import com.example.springboot20200107.response.CommentResponse;
import com.example.springboot20200107.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ScenicSpotDao scenicSpotDao;

    @Override
    public Integer insertComment(AddCommentRequest addCommentRequest) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(addCommentRequest,comment);
        comment.setCreateTime(new Date());
        return commentDao.insertComment(comment);
    }

    @Override
    public Integer updateComment(UpdateCommentRequest updateCommentRequest,Long id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUpdateTime(new Date());
        comment.setComment(updateCommentRequest.getComment());
        return commentDao.updateComment(comment);
    }

    @Override
    public Integer deleteComment(Long id) {
        return commentDao.deleteComment(id);
    }

    @Override
    public List<CommentResponse> selectCommentByUser(Long userId) {
        List<Comment> comments = commentDao.selectCommentByUser(userId);
        return showComentResponse(comments);
    }

    @Override
    public List<CommentResponse> selectCommentByScenicId(Long scenicSpotId) {
        List<Comment> comments = commentDao.selectCommentByScenicId(scenicSpotId);
        return showComentResponse(comments);
    }

    @Override
    public List<CommentResponse> selectAllComment(Integer pageNum) {
        List<Comment> comments = commentDao.selectAllComment(pageNum);
        return showComentResponse(comments);
    }

    @Override
    public Long countAllComment() {
        return commentDao.countAllComment();
    }

    @Override
    public Long countByUserId(Long userId) {
        return commentDao.countByUserId(userId);
    }

    @Override
    public Long countByScenicId(Long scenicSpotId) {
        return commentDao.countByScenicId(scenicSpotId);
    }

    public List<CommentResponse> showComentResponse(List<Comment> comments){
        List<CommentResponse> commentResponseList = new ArrayList<>();
        for (Comment comment:comments) {
            CommentResponse commentResponse = new CommentResponse();
            User user = userDao.selectUserById(comment.getUserId());
            commentResponse.setNickName(user.getNickName());
            ScenicSpot scenicSpot = scenicSpotDao.selectScenicSpotById(comment.getScenicSpotId());
            commentResponse.setScenicSpotName(scenicSpot.getScenicSpotName());
            commentResponse.setComment(comment.getComment());
            commentResponse.setCreateTime(comment.getCreateTime());
            commentResponseList.add(commentResponse);
        }
        return commentResponseList;
    }
}
