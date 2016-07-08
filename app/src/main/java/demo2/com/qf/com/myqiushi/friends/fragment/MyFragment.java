package demo2.com.qf.com.myqiushi.friends.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import demo2.com.qf.com.myqiushi.R;

/**
 * Created by ymll on 2016/7/7.
 */
public class MyFragment extends ListFragment {
    private TextView tv_description_id;// 用来显示当前Fragment的提示信息的
    private int tabIndex;// 便签索引值
    private String tabName;// 标签名
    private Activity context;

    /*
     * (non-Javadoc)
     *
     * @see android.support.v4.app.Fragment#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // 此处，给Fragment实例进行初始化
        Bundle arguments = getArguments();
        tabIndex = arguments.getInt("tabIndex", 0);
        tabName = arguments.getString("tabName", "");
        context = getActivity();
        super.onCreate(savedInstanceState);

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * android.support.v4.app.ListFragment#onCreateView(android.view.LayoutInflater
     * , android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_layout, container, false);

        tv_description_id = (TextView) view
                .findViewById(R.id.tv_description_id);

        return view;
    }

    /*
     * 以后：对Fragment中的视图，将值设置到控件上，都书写在onActivityCreated中，可以万无一失。
     * （原因：能回调该方法，视图都已经加载完毕了）
     *
     * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // 将值设置到Fragment对应的控件上展现出来：
        // ①提示：TextView
        tv_description_id.setText("您点击了第" + (tabIndex + 1) + "个书签！");

        // ②主题：ListView
        List<Map<String, Object>> data = new LinkedList<>();
        // 填充数据源
        fillDataSouce(data);

        SimpleAdapter adapter = new SimpleAdapter(context, data, R.layout.item,
                new String[] { "iv_image_id", "tv_name_id", "tv_pwd_id" },
                new int[] { R.id.iv_image_id, R.id.tv_name_id, R.id.tv_pwd_id });

        // 经典之处：将适配器设置到ListView中
        setListAdapter(adapter);

        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 从网络上下载数据（json，xml，伪造）
     *
     * @param data
     */
    private void fillDataSouce(List<Map<String, Object>> data) {
        for (int i = 1; i <= 20; i++) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("iv_image_id", R.mipmap.ic_launcher);
            map.put("tv_name_id", tabName + i);
            map.put("tv_pwd_id", i);
            data.add(map);
        }
    }
}
