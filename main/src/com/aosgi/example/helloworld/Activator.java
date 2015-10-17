package com.aosgi.example.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class Activator implements BundleActivator {

    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void start(BundleContext context) throws Exception {
        final ServiceReference<Context> ref = context.getServiceReference(Context.class);
        final Context ctx = (Context) context.getService(ref);

        this.handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ctx, "Hello, world!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        final ServiceReference<Context> ref = context.getServiceReference(Context.class);
        final Context ctx = (Context) context.getService(ref);

        this.handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ctx, "Goodbye, world!", Toast.LENGTH_LONG).show();
            }
        });
    }

}
