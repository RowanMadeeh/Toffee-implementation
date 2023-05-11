package view;

/**
 Constructs a new Pair object with the specified values for the first and second elements.
 @param <First>The first value of the pair.
 @param <Second> The second value of the pair.
 */
public class Pair<First, Second> {
    public final First first;
    public final Second second;

    public Pair(First t, Second u) {
        this.first= t;
        this.second= u;
    }
}
