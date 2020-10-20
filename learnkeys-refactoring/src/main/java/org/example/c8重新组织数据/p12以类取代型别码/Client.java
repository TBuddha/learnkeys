package org.example.c8重新组织数据.p12以类取代型别码;

/**
 * @author zhout
 * @date 2020/4/24 15:13
 */
class Client {

  public void test() {
    // Person thePerson = new Person(Person.A);
    // ==>
    Person thePerson = new Person(BloodGroup.A);

    // thePerson.getBloodGroupCode();
    // ==>
    //thePerson.getBloodGroup().getCode();

    // thePerson.setBloodGroup(Person.AB);
    // ==>
    thePerson.setBloodGroup(BloodGroup.AB);
  }
}
