package com.example.springboot20200107.controller;

import com.example.springboot20200107.pojo.Comment;
import com.example.springboot20200107.request.AddCommentRequest;
import com.example.springboot20200107.request.UpdateCommentRequest;
import com.example.springboot20200107.response.CommentResponse;
import com.example.springboot20200107.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    //添加评论
    @PostMapping(value = "insert/comment")
    public Integer insertComment(@RequestBody AddCommentRequest addCommentRequest){
        return commentService.insertComment(addCommentRequest);
    }

    //通过主键id修改评论
    @PutMapping(value = "update/comment")
    public Integer updateComment(UpdateCommentRequest updateCommentRequest,Long id){
        return commentService.updateComment(updateCommentRequest,id);
    }

    //通过主键删除评论
    @DeleteMapping(value = "delete/comment")
    public Integer deleteComment(Long id){
        return commentService.deleteComment(id);
    }

    //通过用户id查看该用户的所有评论
    @GetMapping(value = "select/comment/userId")
    public List<CommentResponse> selectCommentByUser(Long userId){
        return commentService.selectCommentByUser(userId);
    }

    //通过景点id查看该景点的所有评论
    @GetMapping(value = "select/comment/scenicSpotId")
    public List<CommentResponse> selectCommentByScenicId(Long scenicSpotId){
        return commentService.selectCommentByScenicId(scenicSpotId);
    }

    //查看数据库中的所有评论记录
    @GetMapping(value = "select/comment/all")
    public List<CommentResponse> selectAllComment(Integer pageNum){
        return commentService.selectAllComment(pageNum);
    }

    //查看数据库有多少条评论记录
    @GetMapping(value = "count/comment/all")
    public Long countAllComment(){
        return commentService.countAllComment();
    }

    //通过用户id查看该用户有多少条评论
    @GetMapping(value = "count/comment/userId")
    public Long countByUserId(Long userId){
        return commentService.countByUserId(userId);
    }

    //通过景点id查看该景点有多少条评论
    @GetMapping(value = "count/comment/scenicSpotId")
    public Long countByScenicId(Long scenicSpotId){
        return commentService.countByScenicId(scenicSpotId);
    }
}
