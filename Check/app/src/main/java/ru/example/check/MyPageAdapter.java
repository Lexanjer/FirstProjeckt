package ru.example.check;

import android.support.v4.app.*;

public class MyPageAdapter extends FragmentPagerAdapter
{




		MyPageAdapter(FragmentManager fm) {
				super(fm);

		}


		@Override
		public Fragment getItem(int position) {
				return PageFragment.newInstance(position);
		}

		@Override
		public int getCount() {
				return DataBase.PAGE_COUNT;
		}

		@Override
		public CharSequence getPageTitle(int position) {

				//  Log.d(TAG, "------------------------"+title);
				return DataBase.getCheckName(position);
		}

}


