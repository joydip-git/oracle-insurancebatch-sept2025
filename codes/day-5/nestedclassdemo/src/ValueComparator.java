public interface ValueComparator<T> {
    boolean compareValue(T o1, T o2);

    class Comparer<T> implements ValueComparator<T> {
        @Override
        public boolean compareValue(T o1, T o2) {
            return o1.hashCode() > o2.hashCode();
        }
    }
}
