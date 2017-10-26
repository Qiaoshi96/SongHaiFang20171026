package test.bawei.com.songhaifang20171026.mvp.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import test.bawei.com.songhaifang20171026.R;
import test.bawei.com.songhaifang20171026.mvp.presenter.UserBean;

/**
 * Created by Administrator on 2017/10/26.
 */
//创建一个适配器
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<UserBean.SongListBean> list;

    public MyAdapter(List<UserBean.SongListBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        在这里加载我们的子布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            MyViewHolder my= (MyViewHolder) holder;
            my.textView.setText(list.get(position).getAlbum_title());
//            加载图片
            Glide.with(my.imageView.getContext()).load(list.get(position).getPic_small()).into(my.imageView);

        }
//       写接口回调跳转到购物车界面
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
//    创建自己的ViewHolder
static class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView textView;
    public MyViewHolder(View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.item_img);
        textView=itemView.findViewById(R.id.item_text);
    }
}
}
