package com.baron.mysamplearchcomp;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    Button button;
    TextView textView;
    private DrawerLayout drawerLayout;
    private final DemoUtils demoUtils = new DemoUtils();

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsymmetricRecyclerView recyclerView = (AsymmetricRecyclerView) findViewById(R.id.recyclerView);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(demoUtils.moarItems(50));
        recyclerView.setRequestedColumnCount(3);
        recyclerView.setDebugging(true);
        recyclerView.setRequestedHorizontalSpacing(Utils.dpToPx(this, 3));
        recyclerView.addItemDecoration(
                new SpacesItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_padding)));
        recyclerView.setAdapter(new AsymmetricRecyclerViewAdapter<>(this, recyclerView, adapter));


//        button = (Button) findViewById(R.id.button);
//        textView = (TextView) findViewById(R.id.textView);

//        CounterViewModel counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
//        textView.setText(String.valueOf(counterViewModel.counter));


//        button.setOnClickListener((v) -> {
//            counterViewModel.counter++;
//            textView.setText(String.valueOf(counterViewModel.counter));
//
//        });


//        getLifecycle().addObserver(new MusicObserver(this));
//        getLifecycle().addObserver(new LifecycleAwareLogging());

    }


    class RecyclerViewAdapter extends AGVRecyclerViewAdapter<ViewHolder> {
        private final List<DemoItem> items;

        RecyclerViewAdapter(List<DemoItem> items) {
            this.items = items;
        }

        @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d("RecyclerViewActivity", "onCreateView");
            return new ViewHolder(parent, viewType);
        }

        @Override public void onBindViewHolder(ViewHolder holder, int position) {
            Log.d("RecyclerViewActivity", "onBindView position=" + position);
            holder.bind(items.get(position));
        }

        @Override public int getItemCount() {
            return items.size();
        }

        @Override public AsymmetricItem getItem(int position) {
            return items.get(position);
        }

        @Override public int getItemViewType(int position) {
            return position % 2 == 0 ? 1 : 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        ViewHolder(ViewGroup parent, int viewType) {
            super(LayoutInflater.from(parent.getContext()).inflate(
                    viewType == 0 ? R.layout.adapter_item : R.layout.adapter_item_odd, parent, false));
            if (viewType == 0) {
                textView = (TextView) itemView.findViewById(R.id.textview);
            } else {
                textView = (TextView) itemView.findViewById(R.id.textview_odd);
            }
        }

        void bind(DemoItem item) {
            textView.setText(String.valueOf(item.getPosition()));
        }
    }
}
