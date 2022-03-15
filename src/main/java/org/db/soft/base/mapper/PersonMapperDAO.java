package org.db.soft.base.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.db.soft.base.model.Person;
import org.db.soft.base.model.PersonInfo;
import org.db.soft.base.model.Phone;

import java.util.List;

public interface PersonMapperDAO {

    @Results(value = {
            @Result(id = true, column = "personId", property = "personId"),
            @Result(property = "personInfo", column = "personId", javaType = PersonInfo.class,
                    one = @One(select = "getPersonInfoByPersonId" , fetchType = FetchType.LAZY)),
            @Result(property = "phones", column = "personId", javaType = List.class,
                    many = @Many(select = "getPhoneOfByPersonId" , fetchType = FetchType.LAZY))})
    @Select("select * from person where personId = #{personId}")
    public Person getPersonById(int personId);

    @Select("select * from personInfo where personId = #{personId}")
    public PersonInfo getPersonInfoByPersonId(int personId);

    @Select("select * from Phone where personId = #{personId}")
    public Phone getPhoneOfByPersonId(int personId);

    @SelectProvider(type = PersonDynamicSQL.class , method = "queryPersonSQL")
    public Person getPersonByCondition(Person  person);
}


