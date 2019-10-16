package com.lid.outfitplannerbackend.controllers;

import java.util.List;

public interface IController<T> {
    List<T> getAll();

    T getById(int id);
}
