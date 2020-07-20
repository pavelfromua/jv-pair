import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class PairTest {

    private Pair firstPair;
    private Pair secondPair;
    private Pair thirdPair;

    @Before
    public void init() {
        firstPair = Pair.of(5, "Five");
        secondPair = Pair.of(2, "Two");
        thirdPair = Pair.of(5, "Five");
    }

    @Test
    public void methodsCheck() {
        Class<Pair> pairClass = Pair.class;
        Method[] methods = pairClass.getDeclaredMethods();
        Assert.assertTrue("Not all methods were implemented", methods.length >= 5);
        int requiredMethodsCount = 0;
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("hashCode") ||
                    method.getName().equalsIgnoreCase("equals") ||
                    method.getName().equalsIgnoreCase("of") ||
                    method.getName().equalsIgnoreCase("getFirst") ||
                    method.getName().equalsIgnoreCase("getSecond")) {
                requiredMethodsCount++;
            }
        }
        Assert.assertTrue("Not all required methods are implemented!", requiredMethodsCount >= 5);
    }

    @Test
    public void pairsAreEquals() {
        boolean actualResult = firstPair.equals(thirdPair);
        Assert.assertTrue("The result should be true after comparing two the same pairs ",
                actualResult);
    }

    @Test
    public void pairsAreEqualsWithNullParameter() {
        Pair firstPair = Pair.of(null, null);
        Pair secondPair = Pair.of(null, null);
        boolean actualResult = firstPair.equals(secondPair);
        Assert.assertTrue("The result should be true after comparing two the same pairs ",
                actualResult);
    }

    @Test
    public void pairsAreNotEquals() {
        boolean actualResult = firstPair.equals(secondPair);
        Assert.assertFalse("The result should be false after comparing two different pairs ",
                actualResult);
    }

    @Test
    public void pairsAreNotEqualsWithNullObject() {
        Pair nullPair = null;
        boolean actualResult = firstPair.equals(nullPair);
        Assert.assertFalse("The result should be false after comparing two different pairs ",
                actualResult);
    }

    @Test
    public void pairsAreNotEqualsWithNullParameter() {
        Pair firstPairWithNullParameter = Pair.of(null, null);
        boolean actualFirstResult = firstPair.equals(firstPairWithNullParameter);
        boolean actualSecondResult = firstPairWithNullParameter.equals(firstPair);
        Assert.assertFalse("The result should be false after comparing two the same pairs ",
                actualFirstResult);
        Assert.assertFalse("The result should be false after comparing two the same pairs ",
                actualSecondResult);
    }

    @Test
    public void pairsAreEqualsWithComplicatedParameter() {
        Person firstPerson = new Person("Name", "Surname");
        Person secondPerson = new Person("Name", "Surname");
        Address firstAddress = new Address("Street", 1);
        Address secondAddress = new Address("Street", 1);
        Pair firstPair = Pair.of(firstPerson, firstAddress);
        Pair secondPair = Pair.of(secondPerson, secondAddress);
        boolean actualResult = firstPair.equals(secondPair);

        Assert.assertTrue("The result should be true after comparing two the same pairs ",
                actualResult);
    }

    @Test
    public void pairsAreNotEqualsWithComplicatedParameter() {
        Person firstPerson = new Person("Name1", "Surname1");
        Person secondPerson = new Person("Name2", "Surname2");
        Address firstAddress = new Address("Street1", 1);
        Address secondAddress = new Address("Street2", 1);
        Pair firstPair = Pair.of(firstPerson, firstAddress);
        Pair secondPair = Pair.of(secondPerson, secondAddress);
        boolean actualResult = firstPair.equals(secondPair);

        Assert.assertFalse("The result should be false after comparing two different pairs ",
                actualResult);
    }

    @Test
    public void sameObjectHashCodeEqualityTest() {
        Assert.assertEquals("Hash code in the one object is not the same for multiple hash code " +
                "methods calling", firstPair.hashCode(), firstPair.hashCode());
        Assert.assertEquals("Hash code in the one object is not the same for multiple hash code " +
                "methods calling", secondPair.hashCode(), secondPair.hashCode());
        Assert.assertEquals("Hash code in the one object is not the same for multiple hash code " +
                "methods calling", thirdPair.hashCode(), thirdPair.hashCode());
    }

    @Test
    public void sameObjectHashCodeEqualityWithNullParametersTest() {
        Pair firstPair = Pair.of(null, null);
        Pair secondPair = Pair.of(null, null);
        Assert.assertEquals("Hash code in the one object is not the same for multiple hash code " +
                "methods calling", firstPair.hashCode(), secondPair.hashCode());
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals("Hash codes are not equal!", firstPair.hashCode(), thirdPair.hashCode());
        Assert.assertNotEquals("Hash codes should not be equal!", firstPair.hashCode(),
                secondPair.hashCode());
    }

    @Test
    public void getFirstMethodTest() {
        Assert.assertEquals(5, firstPair.getFirst());
        Assert.assertEquals(2, secondPair.getFirst());
    }

    @Test
    public void getSecondMethodTest() {
        Assert.assertEquals("Five", firstPair.getSecond());
        Assert.assertEquals("Two", secondPair.getSecond());
    }
}