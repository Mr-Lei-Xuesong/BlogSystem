package com.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_tag")
@ApiModel("标签实体类")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("名称")
    @NotBlank(message = "标签名称不能为空")
    private String name;
    @ManyToMany(mappedBy = "tags")
    @ApiModelProperty("博客")
    private List<Blog> blogs = new ArrayList<>();
}
