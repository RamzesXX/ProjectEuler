package com.khanchych.sandbox.osgi.osgi2;

import com.khanchych.sandbox.osgi.osgi1.HelloWorldService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class HelloWorldActivator implements BundleActivator {
    private HelloWorldConsumer consumer;

    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference reference = bundleContext.getServiceReference(HelloWorldService.class.getName());

        consumer = new HelloWorldConsumer((HelloWorldService) bundleContext.getService(reference));
        consumer.startTimer();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        consumer.stopTimer();
    }
}