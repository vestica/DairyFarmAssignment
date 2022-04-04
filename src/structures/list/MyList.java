package structures.list;

public interface MyList<T> {
     void add(T t);

     void remove(T t) throws Exception;

     T get(int index);

     int size();


}
