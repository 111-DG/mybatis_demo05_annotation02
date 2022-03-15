package org.db.soft.base.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.db.soft.base.model.Person;

public class PersonDynamicSQL {

    public String queryPersonSQL(Person person) {
        String sql = null;
        sql = new SQL() {
            {
//                UPDATE( "xxx" );
//                SET( "" );
//                DELETE_FROM( "" );

                SELECT( " *" );
                FROM( "person" );
                if (person.getPersonName() != null && person.getPersonEmail() == null && person.getPersonId() == 0) {
                    WHERE( "personName = #{personName}" );
                } else if (person.getPersonName() == null && person.getPersonEmail() != null && person.getPersonId() == 0) {
                    WHERE( "personEmail = #{personEmail}" );
                }else if (person.getPersonName() == null && person.getPersonEmail() == null && person.getPersonId() != 0) {
                    WHERE( "personId = #{personId}" );
                }else if (person.getPersonName() != null && person.getPersonEmail() != null && person.getPersonId() == 0) {
                    WHERE( "personName = #{personName}" );
                    AND();
                    WHERE( "personEmail = #{personEmail}" );
                }else if (person.getPersonName() != null && person.getPersonEmail() == null && person.getPersonId() != 0) {
                    WHERE( "personName = #{personName}" );
                    AND();
//                    OR();
                    WHERE( "personId = #{personId}" );
                }else if (person.getPersonName() == null && person.getPersonEmail() != null && person.getPersonId() != 0) {
                    WHERE( "personEmail = #{personEmail}" );
                    AND();
                    WHERE( "personId = #{personId}" );
                }
            }
        }.toString();
        return sql;
    }

    public static void main(String[] args) {
        Person person = new Person(1,"xiaoming",null,null,null);
        PersonDynamicSQL personDynamicSQL = new PersonDynamicSQL();
        String sql = personDynamicSQL.queryPersonSQL( person );
        System.out.println(sql);


    }
}
