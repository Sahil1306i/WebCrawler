package com.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class URLStore {
    // we will use concurrent hashmap so that it is thread safe
    // also the blocking queue
    private final ConcurrentHashMap<String , Boolean> visitedUrl= new ConcurrentHashMap<>();
    private final BlockingQueue<String> urlQueue = new LinkedBlockingQueue<>();

    public boolean addUrl(String url){
        if(visitedUrl.putIfAbsent(url, true) == null){
            //put if absent returns null when the data is successfully added and true it is not added
            urlQueue.offer(url);
            return true;
        }
        return false;
    }
    public String getNextUrl() throws InterruptedException{
        return urlQueue.poll();
    }

    public boolean isQueueEmpty(){
        return urlQueue.isEmpty();
    }
}
