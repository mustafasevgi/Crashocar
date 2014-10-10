package akturk.crashocar.event;

abstract class BaseEvent<Class> {

    private Class mObject;

    public BaseEvent(Class object) {
        this.mObject = object;
    }

    public Class getData() {
        return mObject;
    }
}
