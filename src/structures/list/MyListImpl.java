package structures.list;

public class MyListImpl<T> implements MyList<T> {


    private  int counter;
    private ListItem<T> firstElement;

    public MyListImpl() {
        this.firstElement = null;
        counter=0;
    }

    @Override
    public void add(T t) {
        if (this.firstElement == null) {
            this.firstElement = new ListItem<>();
            this.firstElement.setNext(null);
            this.firstElement.setData(t);


        } else {
            ListItem<T> current = firstElement;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            ListItem<T> newElement = new ListItem<>();
            newElement.setData(t);
            current.setNext(newElement);
            newElement.setNext(null);

        }
        this.setCounter(this.getCounter()+1);
    }

    @Override
    public void remove(Object t) throws Exception {
        if (this.firstElement == null) {
            throw new Exception("This list is empty, removal not possible!");
        }

        if(firstElement.getData().equals(t)){

           firstElement=firstElement.getNext();
           this.setCounter(this.getCounter()-1);
           return;
        }
        ListItem<T> current=firstElement;
        while(current.getNext()!=null){

            if(current.getNext().getData().equals(t)){
                current.setNext(current.getNext().getNext());
                this.setCounter(this.getCounter()-1);
                return;
            }else{
                current=current.getNext();
            }

        }

    }


    @Override
    public T get(int index) {
        if (index < 0)
            return null;
        ListItem<T> current;
        if (this.firstElement != null) {
            current = this.firstElement;
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;

                current = current.getNext();
            }
            return  current.getData();
        }
        return null;
    }



    @Override
    public int size() {
        return this.getCounter();

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
