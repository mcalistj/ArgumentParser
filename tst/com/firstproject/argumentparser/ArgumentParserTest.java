package com.firstproject.argumentparser;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ArgumentParserTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testHelloWorld() {
        System.setOut(new PrintStream(outContent));
        ArgumentParser argumentParser = new ArgumentParser();
        argumentParser.helloWorld();
        assertEquals("Hello, World!\n", outContent.toString());
    }

}
