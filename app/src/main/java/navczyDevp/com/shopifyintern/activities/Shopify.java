package navczyDevp.com.shopifyintern.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import navczyDevp.com.shopifyintern.R;
import navczyDevp.com.shopifyintern.dataadapter.ProductsAdapter;


public class Shopify extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductsAdapter productsAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext())); // set LayoutManager to RecyclerView
        GetStoriesViewModel model = ViewModelProviders.of(this).get(GetStoriesViewModel.class);
        model.getStoryItems().observe(this, mainModel -> {
            productsAdapter= new ProductsAdapter(Shopify.this,  UniqueTagProcess.Companion.filteredProducts(getIntent().getStringExtra("Tag"),mainModel.getProducts()));
            recyclerView.setAdapter(productsAdapter);
        });

    }
}
