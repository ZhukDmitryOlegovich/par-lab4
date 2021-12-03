import akka.actor.AbstractActor;

import java.util.*;

public class ActorStorage extends AbstractActor {
    private final Map<String, List<ResultTest>> storage = new HashMap<>();

    private void setResult(String id, ResultTest resultTest) {
        List<ResultTest> list = storage.get(id);
        if (list == null) {
            storage.put(id, new List<ResultTest>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<ResultTest> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean add(ResultTest resultTest) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends ResultTest> c) {
                    return false;
                }

                @Override
                public boolean addAll(int index, Collection<? extends ResultTest> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                @Override
                public void clear() {

                }

                @Override
                public ResultTest get(int index) {
                    return null;
                }

                @Override
                public ResultTest set(int index, ResultTest element) {
                    return null;
                }

                @Override
                public void add(int index, ResultTest element) {

                }

                @Override
                public ResultTest remove(int index) {
                    return null;
                }

                @Override
                public int indexOf(Object o) {
                    return 0;
                }

                @Override
                public int lastIndexOf(Object o) {
                    return 0;
                }

                @Override
                public ListIterator<ResultTest> listIterator() {
                    return null;
                }

                @Override
                public ListIterator<ResultTest> listIterator(int index) {
                    return null;
                }

                @Override
                public List<ResultTest> subList(int fromIndex, int toIndex) {
                    return null;
                }
            })
        }
    }
}
