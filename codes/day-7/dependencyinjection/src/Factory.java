import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Factory {

    public Object create(Class<?> interfaceInfo, Class<?> classInfo)
            throws NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException {

                //creating object dynamically using reflection technique
        Constructor<?> ctorInfo = classInfo.getConstructor();
        // return ctorInfo.newInstance();
        return ctorInfo.newInstance();
    }
}
