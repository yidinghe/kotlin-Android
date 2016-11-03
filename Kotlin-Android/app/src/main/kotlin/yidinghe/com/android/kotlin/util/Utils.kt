package yidinghe.com.android.kotlin.util

import android.os.Build

/**
 * Created by yidinghe on 11/3/16.
 */


inline fun supportLoliop(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        code()
    }
}