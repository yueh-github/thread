package threadAtomic;


import entity.Person;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by yuehao on 2017/5/15.
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {

        Person p1 = new Person("im p1");

        Person p2 = new Person("im p2",1);

        AtomicReference atomicReference = new AtomicReference(p1);

        atomicReference.set(p2);

        Person person = (Person) atomicReference.get();

        person.getName();
    }
}
