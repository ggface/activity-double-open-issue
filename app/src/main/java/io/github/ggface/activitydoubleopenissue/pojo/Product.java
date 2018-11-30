package io.github.ggface.activitydoubleopenissue.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

import androidx.annotation.NonNull;
import io.github.ggface.activitydoubleopenissue.StringUtils;

/**
 * Предназначение
 *
 * @author Ivan Novikov on 2018-11-30.
 */
public class Product implements Parcelable {

    public static final Creator<Product> CREATOR = new ClassCreator();

    private final String mName;

    public Product(@NonNull String name) {
        mName = Objects.requireNonNull(name);
    }

    protected Product(Parcel parcel) {
        this(StringUtils.nonNull(parcel.readString()));
    }

    @NonNull
    public String getName() {
        return mName;
    }

    //region Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
    }
    //endregion Parcelable

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product that = (Product) o;
        return Objects.equals(mName, that.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "mName=" + mName +
                '}';
    }

    private static final class ClassCreator implements Creator<Product> {
        @Override
        public Product createFromParcel(Parcel parcel) {
            return new Product(parcel);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    }
}