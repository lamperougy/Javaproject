package com.example.springboot.mapper;

import com.example.springboot.bean.Lost;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SqlMapper {
    /**
     * 登录成功后可对表进行操作，否则退出程序
     * 通过ID查询
     * @param lost
     * @return
     */
    @Select(value ="select * from Lost")
    @Results({
            @Result(id=true,property="lost_id",column="user_id",javaType=String.class),
            @Result(property="lost_name",column="lost_name",javaType=String.class),
            @Result(property="lost_position",column="lost_position",javaType=String.class),
            @Result(property="lost_description",column="lost_description",javaType=String.class),
            @Result(property = "claim_position",column = "claim_position",javaType = String.class),
            @Result(property = "lost_date",column = "lost_date",javaType = String.class),
            @Result(property = "is_returned",column = "is_returned",javaType = Integer.class)
    })
    public String look(@Param("lost") Lost lost);
    /**
     * 登录成功后可对表进行操作，否则退出程序
     * 增加信息
     * @param lost
     * @return
     */
    @Insert("insert into Lost values(#{lost_id},#{lost_name},#{lost_position},#{lost_description},#{claim_position},#{lost_date},#{is_returned})")
    @Options(useGeneratedKeys = true,keyProperty = "lost_id",keyColumn = "lost_id")
    public String add(Lost lost);
    /**
     * 登录成功后可对表进行操作，否则退出程序
     * 删除信息
     * @param lost_id
     * @return
     */
    @Delete("delete from Lost l where l.lost_id=#{lost_id}")
    public String delete(String lost_id);
    /**
     * 登录成功后可对表进行操作，否则退出程序
     * 更新信息
     *
     * @return
     */
    @Update("update Lost set is_returned=#{is_return} where lost_id=#{id}")
    public String update(@Param("is_returned") Integer is_returned, @Param("lost_id") String id);
}
