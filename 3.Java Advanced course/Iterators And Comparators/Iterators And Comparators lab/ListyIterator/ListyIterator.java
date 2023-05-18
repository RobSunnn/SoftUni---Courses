package P14IteratorsAndComparators.exercises.P01ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class ListyIterator implements Iterable<String>{

    private List<String> elements;
    private int index;

    public ListyIterator(String... elements) {
        this.setElements(elements);
        this.index = 0;
    }

    public boolean move() {
        boolean b = index + 1 < elements.size();
        Iterator<String> iterator = iterator();
        if (iterator.hasNext()) {
            iterator.next();
            return true;
        } else {
            return false;
        }
    }

    public boolean hasNext() {
        Iterator<String> iterator = iterator();

        return iterator.hasNext();
    }

    public String print() {
        if (elements.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }
        return elements.get(index);
    }

    public void printAll() {
       for (String s : this.elements) {
           System.out.print(s + " ");
       }
        System.out.println();
    }

    private void setElements(String...elements) {
        if (elements.length == 0) {
            this.elements = new ArrayList<String>();
        } else {
            this.elements = new ArrayList<>(Arrays.asList(elements));
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new iteratorList();
    }

    private final class iteratorList implements Iterator<String> {
        @Override
        public boolean hasNext() {
            return index < elements.size() - 1;
        }
        @Override
        public String next() {
            index++;
            return elements.get(index);
        }
    }


}
