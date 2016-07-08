package demo2.com.qf.com.myqiushi.friends.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import java.util.LinkedList;
import java.util.List;

import demo2.com.qf.com.myqiushi.MyApp;
import demo2.com.qf.com.myqiushi.R;
import demo2.com.qf.com.myqiushi.entity.JavaBean;
import demo2.com.qf.com.myqiushi.friends.activity.ShowActivity;
import demo2.com.qf.com.myqiushi.friends.adapter.MyAdapter;

/**
 * Created by ymll on 2016/7/8.
 */
public class GeBiFragment extends Fragment {
    private String newsUrl;// 要闻Url
    private ListView lv_id;
    private boolean isOver;// 标志值，存储本页的数据是否已经加载完毕（true-->完毕，flase--》还未加载完毕）
    private HttpUtils util;
    private BitmapUtils bitmapUtils;
    private MyAdapter myAdapter;
    private List<JavaBean.ItemsBean> itemsBeen;

    /*
     * (non-Javadoc)
     *
     * @see android.support.v4.app.Fragment#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        util = new HttpUtils();
        bitmapUtils = new BitmapUtils(getActivity());
        Bundle arguments = getArguments();
        newsUrl = arguments.getString("newsUrl");
        super.onCreate(savedInstanceState);
    }
    /*
     * (non-Javadoc)
     *
     * @see
     * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
     * android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_common_fragment, null);
        lv_id = (ListView) view.findViewById(R.id.lv_id);
        return view;
    }
    /*
     * (non-Javadoc)
     *
     * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // 关于ListView
        // 2、准备数据源
        itemsBeen = new LinkedList<>();

        myAdapter = new MyAdapter(itemsBeen,getActivity());

        lv_id.setAdapter(myAdapter);

        // 添加监听器
        // 单击
        lv_id.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //点击listView的时候跳转到一个页面
                Intent intent = new Intent(getActivity(), ShowActivity.class);
                //intent.putExtra("detailUrl", itemsBeen.get(position).getUrl()
                       // .toString());
                startActivity(intent);
            }
        });

        loadDataFromServer();

        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 加载数据
     */
    private void loadDataFromServer() {
        StringRequest stringRequest = new StringRequest("http://m2.qiushibaike.com/article/list/suggest?page=2",
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                JavaBean javaBean = gson.fromJson(response, JavaBean.class);

                itemsBeen.addAll(javaBean.getItems());
            }
        },null);
        stringRequest.setTag("qx");
        MyApp.getApp().getRequestQueue().add(stringRequest);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyApp.getApp().getRequestQueue().cancelAll("qx");
    }




}
