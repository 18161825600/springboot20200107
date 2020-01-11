package com.example.springboot20200107.service;

import com.example.springboot20200107.pojo.Comment;
import com.example.springboot20200107.request.AddCommentRequest;
import com.example.springboot20200107.request.UpdateCommentRequest;
import com.example.springboot20200107.response.CommentResponse;

import java.util.List;

public interface CommentService {

    Integer insertComment(AddCommentRequest addCommentRequest);
    Integer updateComment(UpdateCommentRequest updateCommentRequest,Long id);
    Integer deleteComment(Long id);
    List<CommentResponse> selectCommentByUser(Long userId);
    List<CommentResponse> selectCommentByScenicId(Long scenicSpotId);
    List<CommentResponse> selectAllComment(Integer pageNum);
    Long countAllComment();
    Long countByUserId(Long userId);
    Long countByScenicId(Long scenicSpotId);
}
