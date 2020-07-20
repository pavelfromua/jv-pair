import java.util.Objects;

public class Pair<I, S> {
    private I first;
    private S second;

    public Pair(I first, S second) {
        this.first = first;
        this.second = second;
    }

    public static Pair of(Object first, Object second) {
        return new Pair(first, second);
    }

    public I getFirst() {
        return first;
    }

    public void setFirst(I first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<I, S> pair = (Pair<I, S>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        int hashCode = 17;

        if (first != null) {
            hashCode = hashCode + 31 * first.hashCode();
        }

        if (second != null) {
            hashCode = hashCode + 31 * second.hashCode();
        }

        return hashCode;
    }
}
