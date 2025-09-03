public class NumberValueCollection<T extends Number> implements Collection<T> {

    private Number[] elements;
    private int index;

    public NumberValueCollection() {
        elements = new Number[4];
        index = 0;
    }

    @Override
    public void add(T a) {
        elements[index] = a;
    }
}
