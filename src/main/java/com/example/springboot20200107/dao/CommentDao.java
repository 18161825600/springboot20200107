package com.example.springboot20200107.dao;

import com.example.springboot20200107.mapper.CommentMapper;
import com.example.springboot20200107.pojo.Comment;
import com.example.springboot20200107.pojo.CommentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDao {
    @Autowired
    private CommentMapper commentMapper;

    public Integer insertComment(Comment comment){
        return commentMapper.insert(comment);
    }

    public Integer updateComment(Comment comment){
        return commentMapper.updateByPrimaryKeySelective(comment);
    }

    public Integer deleteComment(Long id){
        return commentMapper.deleteByPrimaryKey(id);
    }

    public List<Comment> selectCommentByUser(Long userId){
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andUserIdEqualTo(userId);
        return commentMapper.selectByExample(commentExample);
    }

    public List<Comment> selectCommentByScenicId(Long scenicSpotId){
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andScenicSpotIdEqualTo(scenicSpotId);
        return commentMapper.selectByExample(commentExample);
    }

    public List<Comment> selectAllComment(Integer pageNum){
        PageHelper.startPage(pageNum,10);
        CommentExample  commentExample = new CommentExample();
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        return pageInfo.getList();
    }

    public Long countAllComment(){
        CommentExample commentExample = new CommentExample();
        return  commentMapper.countByExample(commentExample);
    }

    public Long countByUserId(Long userId){
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andUserIdEqualTo(userId);
        return commentMapper.countByExample(commentExample);
    }

    public Long countByScenicId(Long scenicSpotId){
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andScenicSpotIdEqualTo(scenicSpotId);
        return commentMapper.countByExample(commentExample);
    }

}
