package com.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_comment")
@ApiModel("评论实体类")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("评论内容")
    private String content;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("博主评论")
    private boolean adminComment;
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ManyToOne
    @ApiModelProperty("博客")
    private Blog blog;
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();
    @ManyToOne
    private Comment parentComment;

}
