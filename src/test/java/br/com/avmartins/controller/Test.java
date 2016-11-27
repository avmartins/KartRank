package br.com.avmartins.controller;

import java.net.URL;
import java.util.Enumeration;
 
public class Test
{
    public static void main(String[] args) throws Exception
    {
        Enumeration<URL> e = Test.class.getClassLoader().getResources("");
        while (e.hasMoreElements())
        {
            System.out.println("ClassLoader Resource: " + e.nextElement());
        }
        System.out.println("Class Resource: " + Test.class.getResource("/"));
    }
}