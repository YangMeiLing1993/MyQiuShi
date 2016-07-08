package demo2.com.qf.com.myqiushi.friends;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.viewpagerindicator.TabPageIndicator;

import java.util.LinkedList;
import java.util.List;

import demo2.com.qf.com.myqiushi.R;
import demo2.com.qf.com.myqiushi.common.CommonData;
import demo2.com.qf.com.myqiushi.common.Uris;
import demo2.com.qf.com.myqiushi.friends.fragment.GeBiFragment;
import demo2.com.qf.com.myqiushi.friends.fragment.HuaTiFragment;
import demo2.com.qf.com.myqiushi.friends.fragment.MyFragment;
import demo2.com.qf.com.myqiushi.friends.fragment.VideoFragment;
import demo2.com.qf.com.myqiushi.friends.fragment.YiFenFragment;
import demo2.com.qf.com.myqiushi.utils.ExternalStorageUtil;

/**
 * Created by ymll on 2016/7/7.
 */
public class FriendsFragment extends Fragment {
    private TabPageIndicator mtpi_id;// 标签页指示器自定义控件
    private ViewPager mvp_id;// 页面侧滑的控件

    private View view;// Fragment对应的视图
    private FragmentActivity activity;
    private String[] channelNames={"隔壁","已粉","视频","话题"};// 标签名

    @Override
    public void onCreate(Bundle savedInstanceState) {
        activity = getActivity();
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_friends, null);

        // 界面控件实例初始化
        initWidgets();
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        //读取sd卡信息
        readTabNamesFromSDCard();
        //关于ViewPager的操作
        aboutViewPager();
        //关于TabPageIndicator的操作
        aboutTabPageIndicator();
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 关于TabPageIndicator的操作
     */
    private void aboutTabPageIndicator() {
        // 思路：
        // 1、设定TabPageIndicator与ViewPager之间的关系
        mtpi_id.setViewPager(mvp_id);
    }

    /**
     * 关于ViewPager的操作
     */
    private void aboutViewPager() {
        // 思路：
        // 1、数据源
        final List<Fragment> fragments = new LinkedList<>();
        for (String tabName : channelNames) {
            Fragment fragment = null;
            Bundle args = new Bundle();

            switch (tabName) {
                case CommonData.GEBI:// 隔壁
                    fragment = new GeBiFragment();
                    args.putString("gebiUrl", Uris.TAG_GEBI_FRIENDS.toString());
                    break;
                case CommonData.YIFEN:// 已粉
                    fragment = new YiFenFragment();
                    args.putString("yifenUrl", Uris.TAG_VIDEO_FRIENDS.toString());
                    break;
                case CommonData.SHIPIN:// 视频
                    fragment = new VideoFragment();
                    args.putString("videoUrl", Uris.TAG_VIDEO_FRIENDS.toString());
                    break;
                case CommonData.HUATI:// 话题
                    fragment = new HuaTiFragment();
                    args.putString("huatiUrl", Uris.TAG_HUATI_FRIENDS.toString());
                    break;

                default:
                    break;
            }
            fragment.setArguments(args);
            fragments.add(fragment);
        }

        // 2、适配器
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(
                activity.getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {

                return fragments.get(position);
            }
            @Override
            public int getCount(){
                return fragments.size();
            }
            @Override
            public CharSequence getPageTitle(int position) {

                return channelNames[position];
            }

        };

        // 3、绑定适配器
        mvp_id.setAdapter(adapter);

    }
    /**
     * 找到界面上关心的控件
     */
    private void initWidgets() {
        mtpi_id = (TabPageIndicator) view.findViewById(R.id.tpi_id);
        mvp_id = (ViewPager) view.findViewById(R.id.vp_id);
    }
    /**
     * 从sd卡读取信息
     */
    private void readTabNamesFromSDCard() {
        byte[] datas = ExternalStorageUtil.readDataFromPhone(
                ExternalStorageUtil.getPhoneFileDir(activity),
                "tagNames.txt");
        // 2、关于ViewPager的操作
        aboutViewPager();

        // 3、关于TabPageIndicator的操作
        aboutTabPageIndicator();
    }

}
