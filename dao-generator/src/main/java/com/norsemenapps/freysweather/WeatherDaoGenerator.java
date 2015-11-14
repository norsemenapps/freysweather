package com.norsemenapps.freysweather;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class WeatherDaoGenerator {
    private static final int VERSION_NUMBER = 3;

    /**
     * REMEMBER TO INCREASE VERSION NUMBER WHEN CHANGING THE DATABASE AND CREATE UPDATE SCRIPT
     */
    public static void main(String[] args) throws Exception {
        generateNewDb();
    }

    private static void generateNewDb() throws Exception {
        Schema schema = new Schema(VERSION_NUMBER, "com.norsemenapps.freysweather.model.model.db");
        schema.setDefaultJavaPackageDao("com.norsemenapps.freysweather.model.dao");
        schema.enableKeepSectionsByDefault();
        generateNewEntities(schema);
        new de.greenrobot.daogenerator.DaoGenerator().generateAll(schema, "../mobile/src/main/java/");
    }

    private static void generateNewEntities(Schema schema) {
        Entity forecastPlace = schema.addEntity("ForecastPlace");
        forecastPlace.implementsInterface("Parcelable");
        forecastPlace.addIdProperty();
        forecastPlace.addStringProperty("name");
        forecastPlace.addIntProperty("order");
        forecastPlace.addStringProperty("path").unique();
        forecastPlace.addBooleanProperty("bigCard").notNull();
        forecastPlace.addBooleanProperty("isCurrentLocation").notNull();
    }

}