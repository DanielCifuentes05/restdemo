package com.daniel.restdemo.mapper;

public interface IMapper <I ,O> {
    public O map(I in);
}
