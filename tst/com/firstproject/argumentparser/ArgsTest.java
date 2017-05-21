package com.firstproject.argumentparser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ArgsTest {

    @Test
    public void testGetStringByCharacter() {
        String[] argsArray = {"Hello"};

        Args args = new Args("!p", argsArray);

        assertEquals("Hello", args.getString('p'));
    }

    @Test
    public void testGetStringByCharacterTwoStringsInput() {
        String[] argsArray = {"Hello", "Goodbye"};

        Args args = new Args("!h,!b", argsArray);

        assertEquals("Hello", args.getString('h'));
        assertEquals("Goodbye", args.getString('b'));
    }

    @Test
    public void testGetStringByCharacterWrongReturn() {
        String[] argsArray = {"Hello", "Goodbye"};

        Args args = new Args("!h,!b", argsArray);

        assertNotEquals("Hello", args.getString('b'));
    }

    @Test
    public void testGetBooleanByCharacter() {
        String[] argsArray = {"True", "True"};

        Args args = new Args("@t, @b", argsArray);

        assertEquals(true, args.getBool('t'));
    }

    @Test
    public void testGetIntByCharacter() {
        String[] argsArray = {"5"};

        Args args = new Args("#f", argsArray);

        assertEquals(5, args.getInt('f'));
    }

    @Test
    public void testGetStringByCharacterMultilpeDifferentArgs() {
        String[] argsArray = {"True", "Harry", "Potter", "7"};

        Args args = new Args("@t,!h,!p,#f", argsArray);

        assertEquals(true, args.getBool('t'));
        assertEquals("Harry", args.getString('h'));
        assertEquals("Potter", args.getString('p'));
        assertEquals(7, args.getInt('f'));
        }
}
