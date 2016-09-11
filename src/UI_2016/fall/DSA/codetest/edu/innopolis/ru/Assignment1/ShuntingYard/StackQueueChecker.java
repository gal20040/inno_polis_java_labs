package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment1.ShuntingYard;

class StackQueueChecker<T> {
    static void check(String typeOfStructure, int size, Node node) {
        if (size < 0)
            assert false : typeOfStructure + " size < 0";
        else if (size == 0 && node != null)
            assert false : typeOfStructure + " size == 0 && node != null";
        else if (size >= 1 && node == null)
            assert false : typeOfStructure + " size >= 1 && node == null";
        else if (typeOfStructure.equals(Type.STACK.toString())) {
            if (size == 1 && node.prev != null)
                assert false : typeOfStructure + " size == 1 && tail.prev != null"; //!!!tail.prev
            else if (size > 1 && node.prev == null)
                assert false : typeOfStructure + " size > 1 && tail.prev == null"; //!!!tail.prev
        } else if (typeOfStructure.equals(Type.QUEUE.toString())) {
            if (size == 1 && node.next != null)
                assert false : typeOfStructure + " size == 1 && head.next != null"; //!!!head.next
            else if (size > 1 && node.next == null)
                assert false : typeOfStructure + " size > 1 && head.next == null"; //!!!head.next
        }

        int counter = 0;
        String stringNodeValue = "Value of %s node (from the %s of the %s) is equal null.";
        String auxS = "beginning";
        if (typeOfStructure.equals(Type.STACK.toString()))
            auxS = "top";
        else if (typeOfStructure.equals(Type.QUEUE.toString()))
            auxS = "node";

        while (node != null) {
            counter++;
            if (node.value == null) assert false : String.format(stringNodeValue, counter, auxS, typeOfStructure);

            if (typeOfStructure.equals(Type.STACK.toString())) {
                if (node.prev != null)
                    node = node.prev;
                else
                    node = null;
            }
            else if (typeOfStructure.equals(Type.QUEUE.toString())) {
                if (node.next != null)
                    node = node.next;
                else
                    node = null;
            }
        }
        if (size != counter)
            assert false : String.format("%s size != real %s size", typeOfStructure, typeOfStructure);
    }
}