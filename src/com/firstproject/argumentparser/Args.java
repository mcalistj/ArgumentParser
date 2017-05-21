package com.firstproject.argumentparser;


import lombok.Getter;

import java.util.HashMap;

/**
 * Created by johmcali on 4/8/17.
 */
public class Args {

    private String schema;
    private String[] args;

    public Args(final String schema, final String[] args) {
        this.schema = schema;
        this.args = args;
        parse();
    }

    @Getter
    HashMap<Character, String> stringArgs = new HashMap<Character,String>();

    @Getter
    HashMap<Character, Boolean> booleanArgs = new HashMap<Character,Boolean>();

    @Getter
    HashMap<Character, Integer> integerArgs = new HashMap<Character,Integer>();

    private void parse() {
        Character elementType;
        Character elementIdentifier;
        String[] elements = schema.split(",");

        for (int i = 0; i < elements.length; i++) {
            elementType = elements[i].charAt(0);
            elementIdentifier = elements[i].charAt(1);

            if (elementType == '!') {
                stringArgs.put(elementIdentifier, args[i]);
            }
            else if (elementType == '@') {
                boolean booleanValue = castToBoolean(args[i]);
                booleanArgs.put(elementIdentifier, booleanValue);
            }
            else if (elementType == '#') {
                integerArgs.put(elementIdentifier, Integer.parseInt(args[i]));
            }

        }
    }

    private boolean castToBoolean(final String bool) {
        if (bool.toLowerCase().equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    public int getInt(final Character identifier){
        return getIntegerArgs().get(identifier).intValue();
    }

    public String getString(final Character identifier){
        return getStringArgs().get(identifier);
    }

    public boolean getBool(final Character identifier) {
        return getBooleanArgs().get(identifier).booleanValue();
    }

}
