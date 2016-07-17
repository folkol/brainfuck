package com.folkol.interpreters;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Interpreter
{
    public static void main(String[] args) throws IOException
    {
        byte[] program = Files.readAllBytes(Paths.get(args[0]));
        exec(program, System.in, System.out);
    }

    public static void exec(byte[] program, InputStream in, PrintStream out) throws IOException
    {
        int[] cells = new int[30000];
        int pc = 0;
        int dp = 0;
        while (pc < program.length) {
            switch (program[pc]) {
                case '>':
                    dp++;
                    break;
                case '<':
                    dp--;
                    break;
                case '+':
                    cells[dp]++;
                    break;
                case '-':
                    cells[dp]--;
                    break;
                case '.':
                    out.print((char) cells[dp]);
                    break;
                case ',':
                    cells[dp] = in.read();
                    break;
                case '[':
                    if (cells[dp] == 0) {
                        while (program[pc] != ']') {
                            pc++;
                        }
                    }
                    break;
                case ']':
                    while (program[pc] != '[') {
                        pc--;
                    }
                    continue;
            }
            pc++;
        }
    }
}
