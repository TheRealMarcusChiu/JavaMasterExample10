package native_java.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalExample {

    public static void main(String[] args){
        OptionalExample optionalExample = new OptionalExample();
        Integer value1 = null;
        Integer value2 = 10;

        //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        System.out.println(optionalExample.sum(a,b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        //Optional.isPresent - checks the value is present or not

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.orElse - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.orElse(0); // short for getOrElse(0)

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }

    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "marcus chiu";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        Optional.of(name);
    }

    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = "marcus chiu";
        Optional<String> opt = Optional.ofNullable(name);
        assertTrue(opt.isPresent());
    }

    @Test
    public void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }


    @Test
    public void givenNonNull_yesMapping() {
        Integer i = 0;
        Integer result = Optional.ofNullable(i).map(ii -> ++ii).orElse(null);
        assertEquals(Integer.valueOf(1), result);
    }

    @Test
    public void givenNonNull_yesMapping2() {
        Integer i = 0;
        Integer result = Optional.ofNullable(i).map(ii -> ii++).orElse(null);
        assertEquals(Integer.valueOf(0), result); // map is called but increment is called after return
    }
}
