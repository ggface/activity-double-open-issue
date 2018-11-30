package io.github.ggface.activitydoubleopenissue.details;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import io.github.ggface.activitydoubleopenissue.R;
import io.github.ggface.activitydoubleopenissue.pojo.Product;

/**
 * Предназначение
 *
 * @author Ivan Novikov on 2018-11-30.
 */
public class ProductDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_PRODUCT = "EXTRA_PRODUCT";

    public static void startActivity(@NonNull Activity activity, @NonNull Product product) {
        Intent intent = new Intent(activity, ProductDetailsActivity.class);
        intent.putExtra(EXTRA_PRODUCT, Objects.requireNonNull(product));
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Product product = getIntent().getParcelableExtra(EXTRA_PRODUCT);

        TextView productNameTextView = findViewById(R.id.product_name_text_view);
        productNameTextView.setText(product.getName());
    }
}