package com.android.intelligent.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.intelligent.R;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;

import com.android.intelligent.activities.MajorActivity;
import com.android.intelligent.commonadapter.CommonAdapter;
import com.android.intelligent.commonadapter.ViewHolder;
import com.android.intelligent.models.MajorModel;

import java.util.List;

/**
 * Created by wangchaohu on 2017/1/6.
 */

public class MajorPresenter {

    private Context mContext;
    private MajorActivity majorView;
    private Class[] otherActivitys;

    public MajorPresenter(Context mContext, MajorActivity majorView) {
        this.mContext = mContext;
        this.majorView = majorView;
        setAdapter();
        getIntent();
    }

    /**
     * gridView
     * */
    private void setAdapter() {
        getToOtherActivity();//得到跳转其他activity的acitivy数组

        majorView.setGridViewAdapter(new CommonAdapter(mContext, getGridViewTvData().length, R.layout.item_major_gridview) {
            @Override
            public void convert(ViewHolder helper, final int position) {
                helper.setText(R.id.major_grid_Tv, getGridViewTvData()[position]);
                helper.setImg(R.id.major_grid_Iv, getGridViewIvData()[position]);
            }
        });
    }

    /**得到从其他activity传回来的intent*/
    private void getIntent(){
     //   String s = majorView.getIntent().getExtras().getString("BoilerType");
      //  Log.d("wch", "getIntent: " + s);
    }
    /**
     * 轮播图片
     * */
    public void setPages(ConvenientBanner convenientBanner){
        convenientBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, getImages())
        .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
        .startTurning(3000);
    }

    /**
     * 轮播图片辅助类
     * */
    class LocalImageHolderView implements Holder<Integer>{
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, Integer data) {
            imageView.setImageResource(data);
        }
    }


    /**
     * 得到GridView的图片数据
     */

    private int[] getGridViewIvData() {


        return MajorModel.icons;
    }

    /**
     * 得到GridView的文字数据
     */

    private String[] getGridViewTvData() {

        return MajorModel.iconNames;
    }

    /**
     * 得到GridView的要跳转的Activity
     */

    private void getToOtherActivity() {
        otherActivitys = MajorModel.otherActivities;
    }

    /**
     *
     * */
    public void setOtherActivitys(int position){
        majorView.toOtherActivity(otherActivitys[position]);
    }

    /**
     * 得到轮播图片资源
     * */
    private List<Integer> getImages(){
        return ( MajorModel.getImages())== null ? null : MajorModel.getImages();
    }
}
