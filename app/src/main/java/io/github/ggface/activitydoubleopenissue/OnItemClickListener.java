package io.github.ggface.activitydoubleopenissue;

/**
 * Предназначение
 *
 * @author Ivan Novikov on 2018-11-30.
 */
public interface OnItemClickListener<T> {

    void onItemClick(T element, int position);
}