package com.eightlegged.smabackend.JSON;

import java.io.IOException;
import java.sql.Time;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

<<<<<<< HEAD
=======
/**
 * @author Kim Sae-Young(heehouse1@gmail.com)
 *
 * @FileName JSONDeserializer.java
 * @Project smabackend
 * @Date 2017. 8. 9.
 */

>>>>>>> bdccbae5d5256450be963a397fe11ce9f3c7c164
public class JSONDeserializer extends JsonDeserializer<Time> {
	@Override
    public Time deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return Time.valueOf(jp.getValueAsString() + ":00");
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> bdccbae5d5256450be963a397fe11ce9f3c7c164
