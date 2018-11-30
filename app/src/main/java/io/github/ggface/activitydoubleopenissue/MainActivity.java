package io.github.ggface.activitydoubleopenissue;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ggface.activitydoubleopenissue.details.ProductDetailsActivity;
import io.github.ggface.activitydoubleopenissue.list.ProductAdapter;
import io.github.ggface.activitydoubleopenissue.pojo.Product;

/**
 * Предназначение
 *
 * @author Ivan Novikov on 2018-11-30.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.product_recycler_view);
        recyclerView.setAdapter(new ProductAdapter(mockProducts(), new OnItemClickListener<Product>() {
            @Override
            public void onItemClick(Product element, int position) {
                ProductDetailsActivity.startActivity(MainActivity.this, element);
            }
        }));
    }

    private List<Product> mockProducts() {
        return Arrays.asList(new Product("iPhone"),
                new Product("iMac"),
                new Product("iPad"),
                new Product("Huawei P20"),
                new Product("Кусок говна"),
                new Product("Твой дед"),
                new Product("Дональд Трамп"));
    }
}