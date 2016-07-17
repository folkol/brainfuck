package com.folkol.interpreters;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InterpreterTest
{
    @Test
    public void helloWorld()
        throws Exception
    {
        byte[] program = (
            "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++." +
            "+++++++++++++++++++++++++++++.+++++++..+++.------------------------------" +
            "-------------------------------------.------------.++++++++++++++++++++++" +
            "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.-------" +
            "-.+++.------.--------.---------------------------------------------------" +
            "----------------.").getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Interpreter.exec(program, null, new PrintStream(baos));

        Assert.assertEquals("Hello, world!", baos.toString());
    }

    @Test
    public void helloWorldWithBranch()
        throws Exception
    {
        byte[] program = (
            "+++++++[>++++++++++<-]>++." +
            "+++++++++++++++++++++++++++++.+++++++..+++.------------------------------" +
            "-------------------------------------.------------.++++++++++++++++++++++" +
            "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.-------" +
            "-.+++.------.--------.---------------------------------------------------" +
            "----------------.").getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Interpreter.exec(program, null, new PrintStream(baos));

        Assert.assertEquals("Hello, world!", baos.toString());
    }
}
