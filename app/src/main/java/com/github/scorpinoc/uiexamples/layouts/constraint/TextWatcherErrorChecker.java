package com.github.scorpinoc.uiexamples.layouts.constraint;

import android.text.Editable;
import android.text.TextWatcher;

public class TextWatcherErrorChecker implements TextWatcher {

    private IAfterTextWatcher watcher;

    public TextWatcherErrorChecker(IAfterTextWatcher watcher) {
        this.watcher = watcher;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        watcher.afterTextChanged(editable);
    }

    public interface IAfterTextWatcher {
        public void afterTextChanged(Editable editable);
    }
}
