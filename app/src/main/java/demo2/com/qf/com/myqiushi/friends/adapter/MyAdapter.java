package demo2.com.qf.com.myqiushi.friends.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import demo2.com.qf.com.myqiushi.R;
import demo2.com.qf.com.myqiushi.entity.JavaBean;

/**
 * Created by ymll on 2016/7/8.
 */
// 适配器
public  class MyAdapter extends BaseAdapter {
    private List<JavaBean.ItemsBean> itemsBeen;
    private FragmentActivity geBiFragment;

    public MyAdapter(List<JavaBean.ItemsBean> itemsBeen, FragmentActivity geBiFragment) {
        this.itemsBeen=itemsBeen;
        this.geBiFragment=geBiFragment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;

        if (convertView == null) {
            convertView = View.inflate(geBiFragment, R.layout.gebi_item,
                    null);
            vh = new ViewHolder();
            vh.iv_photo_id = (ImageView) convertView
                    .findViewById(R.id.iv_photo_id);
            vh.tv_user_id = (TextView) convertView
                    .findViewById(R.id.tv_user_id);
            vh.tv_time_id = (TextView) convertView
                    .findViewById(R.id.tv_time_id);
            //内容   用listview的多布局实现
            vh.tv_content_id = (TextView) convertView
                    .findViewById(R.id.tv_content_id);
            vh.tv_address_id = (TextView) convertView
                    .findViewById(R.id.tv_address_id);
            vh.tv_like_id = (TextView) convertView
                    .findViewById(R.id.tv_like_id);
            vh.tv_comment_id = (TextView) convertView
                    .findViewById(R.id.tv_comment_id);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        JavaBean.ItemsBean bean = itemsBeen.get(position);
        vh.tv_user_id.setText(bean.getUser().getLogin());
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {

        return itemsBeen.get(position);
    }

    @Override
    public int getCount() {
        return itemsBeen.size();
    }
    public class ViewHolder{
        private ImageView iv_photo_id;
        private TextView  tv_user_id;
        private TextView  tv_time_id;
        private TextView  tv_content_id;
        private TextView  tv_address_id;
        private TextView  tv_like_id;
        private TextView  tv_comment_id;

    }
}

