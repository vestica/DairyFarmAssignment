package structures;

import structures.list.MyList;
import structures.list.MyListImpl;

class NodeElement<T> {

    private NodeElement<T> parent;
    private T value;
    private MyList<NodeElement<T>> children;

    // This is depth in a tree
    private final int generation;

    //Constructor for root element only
    public NodeElement(T value) {
        this.value = value;
        this.children = new MyListImpl<>();
        this.parent = null;
        this.generation = 0;

    }

    //Constructor for leaves
    public NodeElement(NodeElement<T> parent, T value) {
        this.parent = parent;
        this.value = value;
        this.children = new MyListImpl<>();
        this.generation = parent.getGeneration() + 1;
    }

    NodeElement<T> getParent() {
        return parent;
    }

    void setParent(NodeElement<T> parent) {
        this.parent = parent;
    }

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    MyList<NodeElement<T>> getChildren() {
        return children;
    }

    void setChildren(MyList<NodeElement<T>> children) {
        this.children = children;
    }

    int getGeneration() {
        return generation;
    }


    void giveBirth(NodeElement<T> parent, T child) {
        NodeElement<T> childNode = new NodeElement<>(parent, child);
        this.getChildren().add(childNode);

    }

    void endLifeSpan(NodeElement<T> deceased) throws Exception {


        if (deceased == null) {
            System.out.println("No such cow on this farm.");
            return;
        }
        if (deceased.parent == null) {
            throw new Exception("It is not possible to end life span of oldest ancestor cow. First(root) cow should always be alive.");
        }
        if(deceased.getChildren().size()>0){
            //  Assignment says cows can EITHER give birth to calves by insemination OR end their life spans.
            //  By commenting out this if statement, it would be possible to
            //  remove cow that gave birth (along with her calves).
            throw new Exception("It is not possible to remove cow that gave birth from the family tree.");
        }
        else{
            deceased.parent.getChildren().remove(deceased);
            deceased.parent = null;


        }


    }


    NodeElement<T> searchNodeByValue(T value, NodeElement<T> root) {
        if(root.getValue().equals(value)){
            return root;
        }else{
              int total = root.getChildren().size();
               for(int i=0;i<total;i++) {

                   NodeElement<T> res=searchNodeByValue(value, root.getChildren().get(i));
                   if(res!=null){
                       return res;
                   }
               }


        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("Generation ").append(this.getGeneration()).append(" -> ").append(this.getValue().toString());

        if(this.getChildren().size()>0) {
            sb.append("\n \t \t \t \t").append("Children:").append("\n");
            int total = this.children.size();
            for (int i = 0; i < total; i++) {

                sb.append("\t \t \t \t \t").append(this.children.get(i).getValue());
                sb.append("\n");
            }
        }
        else{
            sb.append("\n \t \t \t \t");
             sb.append("No offspring");
            sb.append("\n");
        }

        return sb.toString();
    }

    void printData(NodeElement<T> root) {
        System.out.println(root.toString());
        int total=root.getChildren().size();
        for(int i=0;i<total;i++){
            printData(root.getChildren().get(i));
        }

    }



}