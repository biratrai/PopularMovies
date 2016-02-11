package com.gooner10.popularmoviesapp.Activity.MovieBus;

import android.os.Bundle;

public class OnItemClickEvent {
    public final Bundle bundle;

    public OnItemClickEvent(Bundle bundle) {
        this.bundle = bundle;
    }


    public Bundle getData() {
        return bundle;
    }
}
