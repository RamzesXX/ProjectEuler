package com.khanchych.sandbox.osgi.osgi2;


import javax.swing.Timer;

import com.khanchych.sandbox.osgi.osgi1.HelloWorldService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorldConsumer implements ActionListener {
    private final HelloWorldService service;
    private final Timer timer;

    public HelloWorldConsumer(HelloWorldService service) {
        super();

        this.service = service;

        timer = new Timer(1000, this);
    }

    public void startTimer(){
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void actionPerformed(ActionEvent e) {
        service.hello();
    }
}