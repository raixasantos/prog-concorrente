package com.trabalho01;

import java.io.IOException;

import com.trabalho01.utils.ApiService;

public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {
        ApiService apiService = new ApiService();
        apiService.sendRequest();
    }
}
