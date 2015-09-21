package com.azhuoinfo.cqurity.activity;

import android.os.Bundle;
import android.view.Gravity;

import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.fragment.UserRoleFragment;

import mobi.cangol.mobile.base.BaseActionBarActivity;
import mobi.cangol.mobile.logging.Log;

/**
 * @Description: 
 * @version $Revision: 1.0 $ 
 */
public class UserInitActivity extends BaseActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinit);
        this.getCustomActionBar().setTitleGravity(Gravity.CENTER);
        this.getCustomActionBar().setDisplayHomeAsUpEnabled(false);
        this.initFragmentStack(R.id.layout_userinit);
        this.getCustomFragmentManager().setDefaultAnimation(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
        findViews();
        initViews(savedInstanceState);
        initData(savedInstanceState);
    }

	@Override
	public void findViews() {

	}
	
	@Override
	public void initViews(Bundle savedInstanceState) {
        if(savedInstanceState==null){
            this.replaceFragment(UserRoleFragment.class, "UserRoleFragment", null);
        }else {
            Log.d("savedInstanceState=" + savedInstanceState);
        }
	}

    @Override
    public void initData(Bundle bundle) {

    }
}