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
@Table(name = "t_user")
@ApiModel("用户实体类")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("用户类型")
    private Integer type;
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty("创建时间")
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @OneToMany(mappedBy = "user")
    @ApiModelProperty("博客")
    private List<Blog> blogs = new ArrayList<>();
}
