package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.TopContributor;

class MyPriorityQueue {
    private static Heap heap = new Heap();

    void put(Node newNode) {
        heap.put(newNode);

        upheap(heap.getSize() - 1);
    }

    private void upheap(int index) {
        Node parentNode = heap.peekAtIndex((index - 1)/2);
        Node currentChildNode = heap.peekAtIndex(index);
        while (index > 0
                && currentChildNode.getPriority() > parentNode.getPriority()) {
            heap.swap(index, (index - 1)/2);

            index = (index - 1)/2;
            parentNode = heap.peekAtIndex((index - 1)/2);
            currentChildNode = heap.peekAtIndex(index);
        }
    }

    Node peek() {
        return heap.peekRoot();
    }

    Node pop() {
        Node node = heap.popRoot();
        downheap(0);

        return node;
    }

    private void downheap(int index) {
        Node leftChildNode = heap.peekAtIndex(2 * index + 1);
        Node rightChildNode = heap.peekAtIndex(2 * index + 2);
        int comparisonResult, newIndex;
        while (index < heap.getSize()
                && (leftChildNode != null
                || rightChildNode != null)
                ) {
            if (leftChildNode != null
                    && rightChildNode != null) {
                comparisonResult = heap.peekAtIndex(2 * index + 1).compareTo(heap.peekAtIndex(2 * index + 2));
                switch (comparisonResult) {
                    case -1:
                        //leftChildNode < rightChildNode
                        newIndex = 2 * index + 2;
                        break;
                    default:
                        //leftChildNode > rightChildNode
                        //leftChildNode = rightChildNode
                        newIndex = 2 * index + 1;
                        break;
                }
            } else if (leftChildNode != null) {
                newIndex = 2 * index + 1;
            } else {
                //in case of (rightChildNode != null)
                newIndex = 2 * index + 2;
            }

            comparisonResult = heap.peekAtIndex(index).compareTo(heap.peekAtIndex(newIndex));
            switch (comparisonResult) {
                case -1:
                    heap.swap(index, newIndex);
                    index = newIndex;
                    leftChildNode = heap.peekAtIndex(2 * index + 1);
                    rightChildNode = heap.peekAtIndex(2 * index + 2);
                    break;
                default:
                    index = heap.getSize();
                    break;
            }
        }
    }
}