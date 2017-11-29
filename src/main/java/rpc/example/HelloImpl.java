package rpc.example;

import rpc.example.interfaces.Hello;

public class HelloImpl implements Hello {
    @Override
    public String sayHello(String name) {
        return "Hello," + name;
    }
}
