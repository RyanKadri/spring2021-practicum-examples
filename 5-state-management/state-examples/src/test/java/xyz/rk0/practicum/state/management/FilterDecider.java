package xyz.rk0.practicum.state.management;

public interface FilterDecider<T> {
    boolean shouldStay(T num);
}
