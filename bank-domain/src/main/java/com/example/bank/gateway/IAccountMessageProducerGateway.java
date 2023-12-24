package com.example.bank.gateway;


import ddd.core.Event;

public interface IAccountMessageProducerGateway {
    void send(Event event);
}
