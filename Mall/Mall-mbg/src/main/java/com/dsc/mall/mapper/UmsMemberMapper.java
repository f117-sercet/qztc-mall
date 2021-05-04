package com.dsc.mall.mapper;

import com.dsc.mall.model.UmsMember;
import com.dsc.mall.model.UmsMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 60221
 *
 */
public interface UmsMemberMapper {
    long countByExample(UmsMemberExample example);

    int deleteByExample(UmsMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);

    List<UmsMember> selectByExample(UmsMemberExample example);

    UmsMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMember record, @Param("example") UmsMemberExample example);

    int updateByExample(@Param("record") UmsMember record, @Param("example") UmsMemberExample example);

    int updateByPrimaryKeySelective(UmsMember record);

    int updateByPrimaryKey(UmsMember record);
}
