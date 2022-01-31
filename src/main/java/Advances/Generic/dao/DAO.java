package Advances.Generic.dao;

// https://www.youtube.com/watch?v=fGNOpFN0rv8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=570

import java.util.List;

/** DAO : data(base) access object */

public class DAO<T> {  // DAO for common table op
    // general methods

    public void add(T t){

    }

    public boolean remove(int index){
        return false;
    }

    public void update(int index){

    }

    public T get(int index){
        return null;
    }

    public List<T> getList(int index){
        return null;
    }

    // generic method
    // E : generic type
    // example : how many record in table ? max time for buying order ?
    public <E> E getValue(){
        return null;
    }
}
