package org.db.soft.base.operation;

import org.apache.ibatis.session.SqlSession;
import org.db.soft.base.mapper.PersonMapperDAO;
import org.db.soft.base.model.Person;
import org.db.soft.base.model.PersonInfo;
import org.db.soft.base.model.Phone;
import org.db.soft.base.utils.Utils;

import java.util.List;

public class OperationServer extends Utils {

    public void testPersonById(int personId){
        SqlSession sqlSession = getSqlSession();
        Person person = sqlSession.getMapper( PersonMapperDAO.class ).getPersonById( personId);
        System.out.println(person.getPersonName());
//        PersonInfo personInfo = person.getPersonInfo();
//        System.out.println(personInfo.getPersonInfoDescribe());
//        List<Phone> phones = person.getPhones();
//        for(Phone phone : phones){
//            System.out.println(phone.getPhoneName());
//        }
    }

    public void testQueryPersonSql(){
        SqlSession sqlSession = getSqlSession();
        Person person = new Person(6,"MT",null,null,null);
        person = sqlSession.getMapper( PersonMapperDAO.class ).getPersonByCondition(  person);
        System.out.println(person.getPersonName());
    }

    public static void main(String[] args) {
        OperationServer operationServer = new OperationServer();
        operationServer.testPersonById(6);
    }
}
