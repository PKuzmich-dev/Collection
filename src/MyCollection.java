import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {
    private int size;
    private Object[] elementData = new Object[10];

    @Override
    public final boolean add(final E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public final int size() {
        return this.size;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public final boolean contains(final Object o) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public final <T> T[] toArray(final T[] a) {
        if (a.length > size) {
            for (int i = 0; i < size; i++) {
                a[i] = (T) elementData[i];
            }
            return a;
        } else {
            return (T[]) Arrays.copyOf(elementData, size);
        }
    }

    @Override
    public final boolean remove(final Object o) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean containsAll(final Collection<?> c) {
        for (Object el : c) {
            if (!this.contains(el)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean addAll(final Collection<? extends E> c) {
        for (E el : c) {
            this.add(el);
        }
        return false;
    }

    @Override
    public final boolean removeAll(final Collection<?> c) {
        boolean result = false;
        for (Object el : c) {
            if (this.remove(el)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public final boolean retainAll(final Collection<?> c) {
        boolean result = false;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (!c.contains(iterator.next())) {
                result = true;
                iterator.remove();
            }
        }
        return result;
    }

    @Override
    public final void clear() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    private class MyIterator<T> implements Iterator<T> {
        private int cursor = 0;
        private boolean nextInvoked = false;

        @Override
        public boolean hasNext() {

            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            nextInvoked = true;
            return (T) elementData[cursor++];
        }

        @Override
        public void remove() {
            if (cursor > 0 && nextInvoked) {
                for (int i = cursor; i < size; i++) {
                    elementData[i - 1] = elementData[i];
                }
                cursor--;
                size--;
                nextInvoked = false;
            } else {
                throw new IllegalStateException("еще не вызывался метод next");
            }
            //throw new UnsupportedOperationException("remove");
        }
    }
}
