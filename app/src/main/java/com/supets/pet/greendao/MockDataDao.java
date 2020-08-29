package com.supets.pet.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.supets.pet.mock.bean.MockData;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MOCK_DATA".
*/
public class MockDataDao extends AbstractDao<MockData, Long> {

    public static final String TABLENAME = "MOCK_DATA";

    /**
     * Properties of entity MockData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Url = new Property(1, String.class, "url", false, "url");
        public final static Property RequestParam = new Property(2, String.class, "requestParam", false, "requestParam");
        public final static Property HeaderParam = new Property(3, String.class, "headerParam", false, "headerParam");
        public final static Property Data = new Property(4, String.class, "data", false, "data");
        public final static Property Time = new Property(5, java.util.Date.class, "time", false, "time");
    }


    public MockDataDao(DaoConfig config) {
        super(config);
    }
    
    public MockDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MOCK_DATA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"url\" TEXT," + // 1: url
                "\"requestParam\" TEXT," + // 2: requestParam
                "\"headerParam\" TEXT," + // 3: headerParam
                "\"data\" TEXT," + // 4: data
                "\"time\" INTEGER);"); // 5: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MOCK_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MockData entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String requestParam = entity.getRequestParam();
        if (requestParam != null) {
            stmt.bindString(3, requestParam);
        }
 
        String headerParam = entity.getHeaderParam();
        if (headerParam != null) {
            stmt.bindString(4, headerParam);
        }
 
        String data = entity.getData();
        if (data != null) {
            stmt.bindString(5, data);
        }
 
        java.util.Date time = entity.getTime();
        if (time != null) {
            stmt.bindLong(6, time.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MockData entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String requestParam = entity.getRequestParam();
        if (requestParam != null) {
            stmt.bindString(3, requestParam);
        }
 
        String headerParam = entity.getHeaderParam();
        if (headerParam != null) {
            stmt.bindString(4, headerParam);
        }
 
        String data = entity.getData();
        if (data != null) {
            stmt.bindString(5, data);
        }
 
        java.util.Date time = entity.getTime();
        if (time != null) {
            stmt.bindLong(6, time.getTime());
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public MockData readEntity(Cursor cursor, int offset) {
        MockData entity = new MockData( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // url
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // requestParam
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // headerParam
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // data
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)) // time
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MockData entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRequestParam(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setHeaderParam(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setData(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTime(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MockData entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MockData entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MockData entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
