package com.dsc.mall.search.domain;

import jdk.javadoc.internal.doclets.toolkit.SerializedFormWriter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * 搜索商品属性
 * @Author:estic
 * @Date: 2021/2/27 12:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EsproductAttributeValue implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long productAttributeId;
    /**属性值
     *
     */
    @Field(type = FieldType.Keyword)
    private String value;
    /**属性参数：0->规格；1->参数
     *
     */
    private Integer type;
    /**属性名称
     *
     */
    @Field(type=FieldType.Keyword)
    private String name;
}
