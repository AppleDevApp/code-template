package com.codebox.codetemplate.mapper;

import com.codebox.codetemplate.domain.Order;
import com.codebox.codetemplate.domain.enums.OrderStatus;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO orderx (id,no,title,totalAmount,createTime,status) VALUES (#{id},#{no},#{title},#{totalAmount},#{createTime},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Order user);

    @Delete("DELETE FROM orderx WHERE id = #{id}")
    int delete(Long id);

    @Update("UPDATE orderx SET no=#{no},title=#{title},totalAmount=#{totalAmount},createTime=#{createTime},status=#{status} WHERE id =#{id}")
    int update(Order user);

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM orderx WHERE id=#{id}")
    Order findById(Long id);

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM orderx")
    List<Order> findAll();

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM orderx WHERE status = #{status}")
    List<Order> findByStatus(OrderStatus status);

    List<Order> selectOrders(OrderStatus status);

    int insertOther(Order user);

}