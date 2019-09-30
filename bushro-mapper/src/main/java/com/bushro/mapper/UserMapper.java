package com.bushro.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author BushRo
 * @Description: TOTO
 * @date 2019-09-30
 */
@Mapper
public interface UserMapper {
    List getUserList();
}
