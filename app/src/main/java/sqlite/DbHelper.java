package sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2021/2/22.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static String name = "test.db";
    private static Integer version = 2;
    private Context mContext;
    public DbHelper(Context context) {
        super(context, name, null, version);
        mContext = context;
    }
    //创建表方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table testbiao(id integer primary key autoincrement,name TEXT)");
            Toast.makeText(mContext, "创建成功", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            System.out.println();
        }
    }
    //升级数据库版本方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            switch (newVersion) {
                case 2:
                    String sex = "sex";
                    //添加列的sql语句
                    String Upgrade = "alter table " + "testbiao" + " add column " + sex + " text";
                    //执行sql语句 一次只能添加一个字段
                    db.execSQL(Upgrade);
                    Toast.makeText(mContext, "添加一个字段成功！", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
