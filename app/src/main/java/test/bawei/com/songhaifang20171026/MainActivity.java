package test.bawei.com.songhaifang20171026;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


import test.bawei.com.songhaifang20171026.mvp.presenter.UserBean;
import test.bawei.com.songhaifang20171026.mvp.view.MyAdapter;


public class MainActivity extends AppCompatActivity {
//    加载一个网络请求

    private  String path="http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0";
    private String path1="http://apiv4.yangkeduo.com/operation/52/groups?opt_type=2&offset=0&size=1&pdduid=";
//    创建一个加载数据
   private List<UserBean.SongListBean> list=new ArrayList<>();
    //        使用封装后的OKhttp,所定义的成员变量
    private OKhttpManager manager = OKhttpManager.getInstance();

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyc);
//        加载需要的数据
        MyAdapter adapter = new MyAdapter(list);
//        指定布局
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
//        调用网络请求方法
        getOK();
    }
//    定义获取网路数据的方法
    public  void getOK(){
       manager.asyncJsonStringByURL(path, new OKhttpManager.Func1() {
           @Override
           public void onResponse(String result) {
//               成功获取到数据开始对数据解析
               Gson gson = new Gson();
               UserBean userBean = gson.fromJson(result, UserBean.class);
               list.addAll(userBean.getSong_list());
           }
       });


    }

}
