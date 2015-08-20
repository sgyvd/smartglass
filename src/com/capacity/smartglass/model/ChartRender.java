package com.capacity.smartglass.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.util.MathHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dellpc on 2015-08-19.
 */
public class ChartRender extends AbstractDemoChart {

    private static final long HOUR = 3600 * 1000;

    private static final long DAY = HOUR * 24;

    private static final int HOURS = 24;

    public Intent execute(Context context) {
        String[] titles = new String[]{"Inside"};
        long now = Math.round(new Date().getTime() / DAY) * DAY;
        List<Date[]> x = new ArrayList<Date[]>();
        for (int i = 0; i < titles.length; i++) {
            Date[] dates = new Date[HOURS];
            for (int j = 0; j < HOURS; j++) {
                dates[j] = new Date(now - (HOURS - j) * HOUR);
            }
            x.add(dates);
        }
        List<double[]> values = new ArrayList<double[]>();

        values.add(new double[]{21.2, 21.5, 21.7, 21.5, 21.4, 21.4, 21.3, 21.1, 20.6, 20.3, 20.2,
                19.9, 19.7, 19.6, 19.9, 20.3, 20.6, 20.9, 21.2, 21.6, 21.9, 22.1, 21.7, 21.5, 21.2, 21.5, 21.7, 21.5, 21.4, 21.4, 21.3, 21.1, 20.6, 20.3, 20.2,
                19.9, 19.7, 19.6, 19.9, 20.3, 20.6, 20.9, 21.2, 21.6, 21.9, 22.1, 21.7, 21.5, 21.2, 21.5, 21.7, 21.5, 21.4, 21.4, 21.3, 21.1, 20.6, 20.3, 20.2,
                19.9, 19.7, 19.6, 19.9, 20.3, 20.6, 20.9, 21.2, 21.6, 21.9, 22.1, 21.7, 21.5, 21.2, 21.5, 21.7, 21.5, 21.4, 21.4, 21.3, 21.1, 20.6, 20.3, 20.2,
                19.9, 19.7, 19.6, 19.9, 20.3, 20.6, 20.9, 21.2, 21.6, 21.9, 22.1, 21.7, 21.5});

//        values.add(new double[] { 151.9, 111.2, 100.9, 90.5, 60.1, 30.5, 67.6, MathHelper.NULL_VALUE,
//                MathHelper.NULL_VALUE, 71.8, 60.3, 91.4, 33.4, 44.9, 27.0, 96.4, 103.4, 52.0, 71.5, 90.9,
//                70.5,
//                MathHelper.NULL_VALUE, 85.9, 92.5,100 ,200});

        int[] colors = new int[]{Color.rgb(78, 186, 250)};
        PointStyle[] styles = new PointStyle[]{PointStyle.CIRCLE, PointStyle.DIAMOND};
        XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
        int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).setFillPoints(true);
        }

        setChartSettings(renderer, "饮水量折线图", "时间", "水量",
                x.get(0)[0].getTime(), x.get(0)[HOURS - 1].getTime(), 21, 24, Color.LTGRAY, Color
                        .LTGRAY);
        renderer.setXLabels(20);
        renderer.setYLabels(20);
        renderer.setShowGrid(true);
        //设置起始Y轴最小值
//      renderer.setYAxisMin(0);
        //xy轴标题大小
        renderer.setAxisTitleTextSize(30);
        //图例大小
        renderer.setLegendTextSize(30);
        //标题大小
        renderer.setChartTitleTextSize(50);
        //横纵坐标标签大小
        renderer.setLabelsTextSize(18);
        //图标的布局
        renderer.setMargins(new int[]{150, 60, 30, 30});
        renderer.setXLabelsAlign(Paint.Align.CENTER);
        renderer.setYLabelsAlign(Paint.Align.RIGHT);
        //可以用在activity的初始化视图上
//        GraphicalView view =ChartFactory.getTimeChartView(context, buildDateDataset(titles, x,
//                        values),
//                renderer, "ah");
//        view.setBackgroundColor(Color.BLUE);
        Intent intent = ChartFactory.getTimeChartIntent(context, buildDateDataset(titles, x, values),
                renderer, "ah");
        return intent;
    }

}
