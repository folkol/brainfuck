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

    @Test
    public void fastForwardNestedBrace()
        throws Exception
    {
        byte[] program = "[[[]]]".getBytes();
        Interpreter.exec(program, System.in, System.out);
    }

    @Test
    public void test()
        throws Exception
    {
        byte[] bytes = "+[[[-]]]".getBytes();
        Interpreter.exec(bytes, null, null);
    }

    @Test
    public void helloWorldWithNestedBranch()
        throws Exception
    {
        byte[] program = (
            "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>." +
            "<-.<.+++.------.--------.>>+.>++.").getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Interpreter.exec(program, null, new PrintStream(baos));

        Assert.assertEquals("Hello World!\n", baos.toString());
    }
}
