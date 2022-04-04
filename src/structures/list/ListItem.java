package structures.list;

 class ListItem<T> {
    private T data;
    private ListItem<T> next;

     ListItem() {
        this.next = null;
    }

     T getData() {
        return data;
    }

     void setData(T data) {
        this.data = data;
    }

     ListItem<T> getNext() {
        return next;
    }

     void setNext(ListItem<T> next) {
        this.next = next;
    }



}
