package com.example;

import java.util.Set;
import java.util.concurrent.Phaser;

public class CrawlerTask implements Runnable{
    // runnable is used so that we can implement multiple inheritance and also implement other classes as well
    private final URLStore urlStore;
    // we can use a constructor to assign the value of final
    private final URLFetcher urlFetcher;
    private final int maxDepth;
    private final int currentDepth;
    private final Phaser phaser;
    //A Phaser in Java is a flexible synchronization utility class (java.util.concurrent.Phaser)
    // that coordinates threads executing tasks in multiple phases

    public CrawlerTask(URLStore urlStore, URLFetcher urlFetcher, int maxDepth, int currentDepth, Phaser phaser) {
        this.urlStore = urlStore;
        this.urlFetcher = urlFetcher;
        this.maxDepth = maxDepth;
        this.currentDepth = currentDepth;
        this.phaser = phaser;
    }
    @Override
    public void run(){
        try {
            String url = urlStore.getNextUrl();
            System.out.println(Thread.currentThread().getName() + "is bad" + url);
            if(url == null || currentDepth > maxDepth)return;

            Set<String> links = urlFetcher.fetchLinks(url);
            for(String link:links){
                if(urlStore.addUrl())
            }

        }catch (Exception e){
            System.out.println("Error!!");
        }finally {

        }
    }
}
