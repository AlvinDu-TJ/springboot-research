package sl.springboot.test.interview;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IteratorInterview {

    static class PeekIterator<T> implements Iterator<T> {

        private T next;
        private Iterator<T> it;

        public PeekIterator(Iterator<T> i){
            it = i;
            next = this.it.next();
        }

        @Override
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override
        public T next() {
            next = this.it.hasNext()? this.it.next():null;
            return next;
        }

        public T peek() {
            return next;
        }
    }
    public static void main(String[] args) {
        List<Integer> collect = IntStream.range(10, 12).boxed().collect(Collectors.toList());
        PeekIterator p = new PeekIterator(collect.iterator());
        System.out.println("p.peek() = " + p.peek());
        p.next();
        System.out.println("p.peek() = " + p.peek());
        p.next();
        System.out.println("p.peek() = " + p.peek());
    }
}
