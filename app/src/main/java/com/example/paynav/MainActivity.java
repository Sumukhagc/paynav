package com.example.paynav;


import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.paynav.fragment.DueFragment;
import com.example.paynav.fragment.NotificationFragment;
import com.example.paynav.fragment.PaymentFragment;
import com.example.paynav.fragment.PlusFragment;
import com.example.paynav.fragment.ProfileFragment;
import com.example.paynav.fragment.RequestFragment;
import com.example.paynav.fragment.ScannerFragment;
import com.example.paynav.fragment.SplitFragment;
import com.example.paynav.fragment.TransactionFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout linearLayout;
    int dot_count;
    ImageView[] dot;
    RelativeLayout rl1,rl2,rl3,rl4;
    ImageButton home,dues,requests,profile;
    TextView viewall;
    ImageView scanner,notification;
    FloatingActionButton plus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView( R.layout.activity_main );
        viewPager = (ViewPager) findViewById( R.id.viewpager );

        setAllIds();
        navigate_to_activity();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter( this );
 linearLayout=findViewById( R.id.linearlayout );
        viewPager.setAdapter( viewPagerAdapter );
        dot_count = viewPagerAdapter.getCount();
        dot = new ImageView[dot_count];
        for (int i = 0; i < dot_count; i++) {
            dot[i] = new ImageView( this );
            dot[i].setImageDrawable( ContextCompat.getDrawable( getApplicationContext(), R.drawable.off_dot ) );
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );
            params.setMargins( 8, 0, 8, 0 );
            linearLayout.addView( dot[i], params );


        }
        dot[0].setImageDrawable( ContextCompat.getDrawable( getApplicationContext(), R.drawable.on_dot ) );
        viewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
for(int j=0;j<dot_count;j++)
{
    dot[j].setImageDrawable( ContextCompat.getDrawable( getApplicationContext(),R.drawable.off_dot ) );

}
     dot[position].setImageDrawable( ContextCompat.getDrawable( getApplicationContext(),R.drawable.on_dot ) );
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        } );


        Timer timer=new Timer(  );
        timer.scheduleAtFixedRate( new TimerTask1(),2000,4000 );
    }

    private void navigate_to_activity() {
        viewall.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this,"You clicked View all! ",Toast.LENGTH_SHORT).show();
            }
        } );
        rl1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaymentFragment paymentFragment = new PaymentFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle b = new Bundle();
                paymentFragment.setArguments(b);
                fragmentTransaction.replace(R.id.contain_layout, paymentFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        } );
        rl2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaymentFragment paymentFragment = new PaymentFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle b = new Bundle();
                b.putString("details", "Amount of 4200 is to be paid to Harshada Nikam");
                paymentFragment.setArguments(b);
                fragmentTransaction.replace(R.id.contain_layout, paymentFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        } );
        rl3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransactionFragment makeTransactionFragment = new TransactionFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contain_layout, makeTransactionFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        } );
        rl4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplitFragment splitBillFragment = new SplitFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contain_layout, splitBillFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        } );
        plus.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        startActivity( new Intent(MainActivity.this,plus.class) );
    }
} );
profile.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity( new Intent(MainActivity.this,profile.class) );
    }
} );
dues.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        DueFragment dueFragment = new DueFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contain_layout, dueFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
} );
requests.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        RequestFragment requestFragment = new RequestFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contain_layout, requestFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
} );
home.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText( MainActivity.this,"You are already in main activity!!! " ,Toast.LENGTH_SHORT).show();
    }
} );
scanner.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ScannerFragment scannerFragment = new ScannerFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contain_layout, scannerFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
} );
notification.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       NotificationFragment n = new NotificationFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contain_layout, n);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
} );
plus.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        PlusFragment plusFragment = new PlusFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contain_layout, plusFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
} );
profile.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ProfileFragment profileFragment = new ProfileFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contain_layout, profileFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
} );


    }


    private void setAllIds() {
        rl1= findViewById( R.id.rl1 );
        rl2=findViewById( R.id.rl2 );
        rl3= findViewById( R.id.rl3 );
        rl4= findViewById( R.id.rl4 );
        home=findViewById( R.id.home );
        requests=findViewById( R.id.requests );
        profile=findViewById( R.id.profile );
        dues=findViewById( R.id.dues );
        viewall=findViewById( R.id.viewall );
        scanner=findViewById( R.id.scanner );
        notification=findViewById( R.id.notifications );
        plus=findViewById( R.id.plus );

    }

    public class TimerTask1 extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread( new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem( 1 );
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem( 2 );
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem( 3 );
                    } else {
                        viewPager.setCurrentItem( 0 );
                    }

                }
            } );

        }
    }


}