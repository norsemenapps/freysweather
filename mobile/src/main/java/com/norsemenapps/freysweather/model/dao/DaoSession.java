package com.norsemenapps.freysweather.model.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.norsemenapps.freysweather.model.model.db.ForecastPlace;

import com.norsemenapps.freysweather.model.dao.ForecastPlaceDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig forecastPlaceDaoConfig;

    private final ForecastPlaceDao forecastPlaceDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        forecastPlaceDaoConfig = daoConfigMap.get(ForecastPlaceDao.class).clone();
        forecastPlaceDaoConfig.initIdentityScope(type);

        forecastPlaceDao = new ForecastPlaceDao(forecastPlaceDaoConfig, this);

        registerDao(ForecastPlace.class, forecastPlaceDao);
    }
    
    public void clear() {
        forecastPlaceDaoConfig.getIdentityScope().clear();
    }

    public ForecastPlaceDao getForecastPlaceDao() {
        return forecastPlaceDao;
    }

}
