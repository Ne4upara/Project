package goit.project.servis;

import java.nio.charset.StandardCharsets;

public class Coder {

    public static String UTF_8 (String text){
        return new String(text.getBytes(), StandardCharsets.UTF_8);
    }
}
