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
@Table(name = "t_blog")
@ApiModel("博客实体类")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("内容")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content;
    @ApiModelProperty("首图")
    private String firstPicture;
    @ApiModelProperty("标记")
    private String flag;
    @ApiModelProperty("浏览次数")
    private Integer views;
    @ApiModelProperty("赞赏是否开启")
    private boolean appreciation;
    @ApiModelProperty("版权是否开启")
    private boolean shareStatement;
    @ApiModelProperty("评论是否开启")
    private boolean commentAble;
    @ApiModelProperty("发布")
    private boolean published;
    @ApiModelProperty("是否推荐")
    private boolean recommend;
    @ApiModelProperty("描述")
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty("创建时间")
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ManyToOne
    @ApiModelProperty("类型")
    private Type type;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @ApiModelProperty("标签")
    private List<Tag> tags = new ArrayList<>();
    @ManyToOne
    @ApiModelProperty("用户")
    private User user;
    @OneToMany(mappedBy = "blog")
    @ApiModelProperty("评论")
    private List<Comment> comments = new ArrayList<>();
    @Transient
    private String tagIds;

    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuilder buffer = new StringBuilder();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    buffer.append(",");
                } else {
                    flag = true;
                }
                buffer.append(tag.getId());
            }
            return buffer.toString();
        } else {
            return tagIds;
        }
    }
}
