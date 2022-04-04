package structures;

import domain.Cow;


public class Farm {

    private final NodeElement<Cow> cowFamilyTree;

    public Farm(Cow root) {
        this.cowFamilyTree = new NodeElement<>(root);
    }

    public void giveBirth(int parentCowId, int childCowId, String childNickName) {

        Cow babyCow = new Cow(childCowId, childNickName);
        NodeElement<Cow> parentCow = cowFamilyTree.searchNodeByValue(new Cow(parentCowId),cowFamilyTree);
        System.out.println("--- "+parentCow.getValue().getNickName()+" is giving birth to calf - "+childNickName+" with ID "+childCowId);
        NodeElement<Cow> child = cowFamilyTree.searchNodeByValue(new Cow(childCowId),cowFamilyTree);
        if (child == null) {
            parentCow.giveBirth(parentCow, babyCow);
            System.out.println("New calf added to the farm!");
        } else {
            System.out.println("!Cow with this ID("+childCowId+") was already born, and exists in cow family tree.\n "
                    + "It is not possible to give birth to cow with the same ID!");
        }

    }

    public void endLifeSpan(int cowId) {
        System.out.println("Removing cow with ID: " + cowId);
        NodeElement<Cow> deceased = cowFamilyTree.searchNodeByValue(new Cow(cowId),cowFamilyTree);
        try {
            cowFamilyTree.endLifeSpan(deceased);
            System.out.println("Cow with ID "+deceased.getValue().getCowId()+" is now deceased.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void printData() {
        cowFamilyTree.printData(this.cowFamilyTree);
    }


}
