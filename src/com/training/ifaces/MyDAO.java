package com.training.ifaces;

import java.util.List;

public interface MyDAO<T> {

  public int add(T object);

  public int delete(int donorID);

  public T find(int donorID);

  public int update(int donorID, int newAmountDonated);

  public List<T> findAll();

}
