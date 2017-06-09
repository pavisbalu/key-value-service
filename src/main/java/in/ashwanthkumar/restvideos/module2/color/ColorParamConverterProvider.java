package in.ashwanthkumar.restvideos.module2.color;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class ColorParamConverterProvider implements ParamConverterProvider {
    final ColorParamConverter converter = new ColorParamConverter();

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> aClass, Type type, Annotation[] annotations) {
        if (!Color.class.equals(aClass)) {
            return null;
        }

        return (ParamConverter<T>) converter;
    }
}
