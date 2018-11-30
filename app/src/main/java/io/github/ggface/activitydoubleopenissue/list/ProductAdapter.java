package io.github.ggface.activitydoubleopenissue.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ggface.activitydoubleopenissue.OnItemClickListener;
import io.github.ggface.activitydoubleopenissue.R;
import io.github.ggface.activitydoubleopenissue.pojo.Product;

/**
 * Предназначение
 *
 * @author Ivan Novikov on 2018-11-30.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    @NonNull
    private final List<Product> mItems;

    @NonNull
    private final OnItemClickListener<Product> mOnItemClickListener;

    public ProductAdapter(@NonNull List<Product> products,
                          @NonNull OnItemClickListener<Product> itemClickListener) {
        mItems = Objects.requireNonNull(products);
        mOnItemClickListener = Objects.requireNonNull(itemClickListener);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder viewHolder, int position) {
        viewHolder.bindView(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mProductNameTextView;

        ProductViewHolder(View view) {
            super(view);
            itemView.setOnClickListener(this);
            mProductNameTextView = view.findViewById(R.id.product_name_text_view);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position > RecyclerView.NO_POSITION) {
                mOnItemClickListener.onItemClick(mItems.get(position), position);
            }
        }

        void bindView(@NonNull Product product) {
            mProductNameTextView.setText(Objects.requireNonNull(product).getName());
        }
    }
}