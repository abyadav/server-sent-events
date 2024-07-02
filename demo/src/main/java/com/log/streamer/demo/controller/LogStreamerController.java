package com.log.streamer.demo.controller;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping(value = "/logs")
public class LogStreamerController {

	
	
	 private final ExecutorService executor = Executors.newCachedThreadPool();

	    @GetMapping("/stream-sse")
	    public SseEmitter streamSseEvents() {
	        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE); // Long-lived connection
	        Thread t1 = new Thread(new Runnable() {

				@Override
				public void run() {
					while(true) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						try {
							emitter.send("SSE - " + System.currentTimeMillis());
						} catch (IOException e) {
							e.printStackTrace();
							emitter.complete();
						}
					}
					
				}
	        	
	        });
	        
	        executor.execute(t1);
	        return emitter;
	    }
}
