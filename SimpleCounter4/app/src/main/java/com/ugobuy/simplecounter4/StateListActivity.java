package com.ugobuy.simplecounter4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class StateListActivity extends Activity {
	
	private ListView listView ;
	private ArrayAdapter<String> mAdapter ;	
	private ArrayList<Uri> mUriList = new ArrayList<>();
	private String[] mStateList ;	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState) ;
		setContentView(R.layout.state_list_activity);

		listView =  findViewById(R.id.listView);
		mStateList = getResources().getStringArray(R.array.stateList) ;
		
		mAdapter = new ArrayAdapter<>(this, R.layout.list_item, mStateList) ;

		listView.setAdapter(mAdapter);
		
		initializeStateUris() ;
		

		listView.setOnItemClickListener((parent, view, position, it) -> {

			Uri aUri = mUriList.get(position) ;
			Intent aIntent = new Intent(Intent.ACTION_VIEW);
			aIntent.setData(aUri) ;
			aIntent.addCategory(Intent.CATEGORY_BROWSABLE) ;
			if(aIntent.resolveActivity(getPackageManager()) != null) {
				startActivity(aIntent);
			}
		}) ;

	}
	
//	public void onListItemClick(ListView parent,
//								View view, int position, long resourceID) {
//
//		Uri aUri = mUriList.get(position) ;
//		Intent aIntent = new Intent(Intent.ACTION_VIEW);
//		aIntent.setData(aUri) ;
//		aIntent.addCategory(Intent.CATEGORY_BROWSABLE) ;
//		startActivity(aIntent) ;
//	}

	private void initializeStateUris() {

		mUriList.add(Uri.parse("http://www.mass.gov")) ;
		mUriList.add(Uri.parse(getString(R.string.Connecticut_URI))) ;
		mUriList.add(Uri.parse("http://www.ri.gov/")) ;
		mUriList.add(Uri.parse("http://www.vermont.gov")) ;
		mUriList.add(Uri.parse("http://www.nh.gov")) ;
		mUriList.add(Uri.parse(getString(R.string.Main_URI))) ;
		mUriList.add(Uri.parse("http://www.patriots.com")) ;
	}

	protected void onPause() {
		super.onPause() ;
		setResult(RESULT_OK) ;

	}

}
