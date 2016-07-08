package demo2.com.qf.com.myqiushi.common;

import android.os.Environment;

/**
 * Created by ymll on 2016/7/8.
 */
public class CommonData {
    // SD卡,普通文档公共目录
    public static final String DOCUMENTS_DIR = Environment
            .getExternalStorageDirectory().toString();

    // 频道
    public static final String GEBI = "隔壁";
    public static final String YIFEN = "已粉";
    public static final String SHIPIN = "视频";
    public static final String HUATI = "话题";
}
