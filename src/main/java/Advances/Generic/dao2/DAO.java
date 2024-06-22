package Advances.Generic.dao2;

// https://www.youtube.com/watch?v=SqqPjmtseSs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=575

import java.util.*;

public class DAO<T> {

  Map<String, T> map = new HashMap<>();

  // method
  // save T type object to Map
  public void save(String id, T entity) {
    map.put(id, entity);
  }

  // get key=id's value from Map
  public T get(String id) {
    return map.get(id);
  }

  // replace key=id 's value with entity object
  public void update(String id, T entity) {
    if (map.containsKey(id)) {
      map.put(id, entity);
    }
  }

  // return all objects in Map
  public List<T> list() {
    List<T> list = new ArrayList<>();
    Collection<T> values = map.values();
    for (T t : values) {
      list.add(t);
    }
    return list;
  }

  // delete key=id object in Map
  public void delete(String id) {
    map.remove(id);
  }
}
