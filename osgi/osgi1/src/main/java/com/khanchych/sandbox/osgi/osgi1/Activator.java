package com.khanchych.sandbox.osgi.osgi1;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    BundleContext bundleContext;
    private ServiceRegistration registration;

    public void start(BundleContext bundleContext) throws Exception {
        this.bundleContext = bundleContext;
        registration = bundleContext.registerService(
                HelloWorldService.class.getName(),
                new HelloWorldServiceImpl(),
                null);
        System.out.println("Bundle activator has started.");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        registration.unregister();
        System.out.println("Bundle activator has stopped.");
    }
}
