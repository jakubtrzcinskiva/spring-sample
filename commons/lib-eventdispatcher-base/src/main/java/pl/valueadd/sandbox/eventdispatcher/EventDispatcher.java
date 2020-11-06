package pl.valueadd.sandbox.eventdispatcher;

import java.io.Serializable;

public interface EventDispatcher {
    void dispatch(Serializable event);
}