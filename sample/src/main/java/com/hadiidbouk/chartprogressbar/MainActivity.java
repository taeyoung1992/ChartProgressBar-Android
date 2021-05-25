package com.hadiidbouk.chartprogressbar;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hadiidbouk.charts.BarData;
import com.hadiidbouk.charts.ChartProgressBar;
import com.hadiidbouk.charts.OnBarClickedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnBarClickedListener {

	private ChartProgressBar mChart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ArrayList<BarData> dataList = new ArrayList<>();

		BarData data = new BarData("", 0f, "");
		dataList.add(data);

//		data = new BarData("", 8.0f, "");
//		dataList.add(data);
//
//		data = new BarData("", 1.8f, "1");
//		dataList.add(data);
//
//		data = new BarData("", 7.3f, "");
//		dataList.add(data);
//
//		data = new BarData("", 6.2f, "");
//		dataList.add(data);
//
//		data = new BarData("", 3.3f, "");
//		dataList.add(data);

		mChart = (ChartProgressBar) findViewById(R.id.ChartProgressBar);

		mChart.setDataList(dataList);
		mChart.build();
		mChart.setOnBarClickedListener(this);
		mChart.disableBar(dataList.size() - 1);
	}

	public void BtnPressed(View view) {
		int id = view.getId();
		switch (id) {
			case R.id.BtnClear :
				mChart.removeBarValues();
				break;
			case R.id.BtnReset :
				mChart.resetBarValues();
				break;
			case R.id.BtnClearClick :
				mChart.removeClickedBar();
				break;
			case R.id.BtnColorChangeClick :
				mChart.setProgressColor(R.color.c_007aff);
				mChart.build();
				break;
		}
	}

	@Override public void onBarClicked(int index) {
		Toast.makeText(this, String.valueOf(index), Toast.LENGTH_SHORT).show();
	}
}
